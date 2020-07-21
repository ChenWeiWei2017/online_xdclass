package xyz.chenww.online_xdclass.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import xyz.chenww.online_xdclass.mapper.EpisodeMapper;
import xyz.chenww.online_xdclass.model.entity.Episode;
import xyz.chenww.online_xdclass.model.entity.Video;
import xyz.chenww.online_xdclass.model.entity.VideoBanner;
import xyz.chenww.online_xdclass.mapper.VideoBannerMapper;
import xyz.chenww.online_xdclass.mapper.VideoMapper;
import xyz.chenww.online_xdclass.service.VideoService;
import xyz.chenww.online_xdclass.utils.BaseCache;
import xyz.chenww.online_xdclass.utils.Constant;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 功能描述：视频课程服务
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private VideoBannerMapper videoBannerMapper;

    @Resource
    private EpisodeMapper episodeMapper;

    // 使用缓存
    private final BaseCache baseCache;

    public VideoServiceImpl(BaseCache baseCache) {
        this.baseCache = baseCache;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<VideoBanner> listVideoBanners(int num) {
        try {
            Object cache = baseCache.getTenMinutesCache().get(Constant.CacheKey.INDEX_BANNER_KEY.getKey(), () -> videoBannerMapper.findBanners(num));
            if (cache instanceof List) {
                return (List<VideoBanner>) cache;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Video> listVideos(int pageNum, int pageSize) {
        try {
            Object cache = baseCache.getTenMinutesCache().get(Constant.CacheKey.INDEX_VIDEO_LIST_KEY.getKey(), () -> {
                PageHelper.startPage(pageNum, pageSize);
                return videoMapper.findAll();
            });
            if (cache instanceof List) {
                return (List<Video>) cache;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 可以返回一些兜底数据（业务系统降级）
        return null;
    }

    @Override
    public Video findVideoDetailById(int videoId) {
        // 一个视频对应一个key
        String cacheKey = String.format(Constant.CacheKey.VIDEO_DETAIL.getKey(), videoId);
        try {
            Object cache = baseCache.getOneHourCache().get(cacheKey, () -> videoMapper.findDetailById(videoId));
            if (cache instanceof  Video) {
                return (Video) cache;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Episode findFirstEpisodeInVideo(int videoId) {
        return episodeMapper.findByVideoIdAndNum(videoId, 1);
    }

}
