package xyz.chenww.online_xdclass.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.chenww.online_xdclass.exception.XDException;
import xyz.chenww.online_xdclass.mapper.PlayRecordMapper;
import xyz.chenww.online_xdclass.mapper.VideoMapper;
import xyz.chenww.online_xdclass.mapper.VideoOrderMapper;
import xyz.chenww.online_xdclass.model.entity.Episode;
import xyz.chenww.online_xdclass.model.entity.PlayRecord;
import xyz.chenww.online_xdclass.model.entity.Video;
import xyz.chenww.online_xdclass.model.entity.VideoOrder;
import xyz.chenww.online_xdclass.service.OrderService;
import xyz.chenww.online_xdclass.service.VideoService;
import xyz.chenww.online_xdclass.utils.Constant;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 功能描述：订单服务
 *
 * @author chenweiwei
 * @since 2020/7/9
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private VideoOrderMapper videoOrderMapper;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private PlayRecordMapper playRecordMapper;

    private final VideoService videoService;

    public OrderServiceImpl(VideoService videoService) {
        this.videoService = videoService;
    }

    /**
     * 下单操作
     * 未来版本：优惠券抵扣，风控用户检测，生成订单信息，生成支付信息等
     * @param userId 用户Id
     * @param videoId 视频Id
     * @return 1: 成功；其他: 失败，目前只有一个0，如果有完整的逻辑，则可以定义多个错误状态码并返回具体的下单失败信息
     */
    @Override
    @Transactional
    public int save(int userId, int videoId) {
        // 1.判断用户是否已经购买该视频，一个用户同一个视频只能购买一次
        VideoOrder videoBuy = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, Constant.PayState.HAS_PAY.getValue());
        if (videoBuy != null) {
            return 0;
        }
        // 查询所购视频信息，作冗余字段存入
        Video video = videoMapper.findById(videoId);
        if (video == null) {
            return 0;
        }
        // 封装视频订单
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setCreateTime(new Date());
        // 默认完成支付逻辑并成功，返回了订单号
        videoOrder.setOutTradeNo(UUID.randomUUID().toString());
        videoOrder.setState(Constant.PayState.HAS_PAY.getValue());
        videoOrder.setUserId(userId);
        videoOrder.setVideoId(videoId);
        videoOrder.setTotalFee(video.getPrice());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());

        videoOrderMapper.save(videoOrder);

        // 如果下单成功，则会将自动生成的id传给videoOrder
        if (videoOrder.getId() != null && videoOrder.getId() > 0) {
            // 下单购买成功后，默认生成一条初始的播放记录，便于用户学习已购买的课程
            Episode firstEpisode = videoService.findFirstEpisodeInVideo(videoId);
            if (firstEpisode == null) {
                // 无集数信息，抛出异常
                throw new XDException(-2, "视频信息不完整，请联系运营人员进行检测");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecord.setCurrentNum(1);
            playRecord.setEpisodeId(firstEpisode.getId());
            playRecord.setCreateTime(new Date());

            playRecordMapper.save(playRecord);

            return playRecord.getId() != null && playRecord.getId() > 0 ? 1 : 0;
        }

        return 0;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {
        return videoOrderMapper.findByUserId(userId);
    }
}
