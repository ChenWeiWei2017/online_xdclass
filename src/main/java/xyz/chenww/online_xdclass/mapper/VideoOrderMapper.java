package xyz.chenww.online_xdclass.mapper;

import xyz.chenww.online_xdclass.model.entity.VideoOrder;

/**
 * 功能描述：视频订单
 *
 * @author chenweiwei
 * @since 2020/7/9
 */
public interface VideoOrderMapper {

    VideoOrder findByUserIdAndVideoIdAndState(Integer userId, Integer videoId, Integer state);

    void save(VideoOrder videoOrder);
}
