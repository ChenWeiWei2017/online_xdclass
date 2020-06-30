package xyz.chenww.online_xdclass.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import xyz.chenww.online_xdclass.model.entity.Video;
import xyz.chenww.online_xdclass.model.entity.VideoBanner;
import xyz.chenww.online_xdclass.mapper.VideoBannerMapper;
import xyz.chenww.online_xdclass.mapper.VideoMapper;
import xyz.chenww.online_xdclass.service.VideoService;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<VideoBanner> listVideoBanners(int num) {
        return videoBannerMapper.findBanners(num);
    }

    @Override
    public List<Video> listVideos(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return videoMapper.findAll();
    }

    @Override
    public Video findVideoDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }
}
