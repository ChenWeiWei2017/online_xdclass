package xyz.chenww.online_xdclass.service;

import xyz.chenww.online_xdclass.model.entity.Video;
import xyz.chenww.online_xdclass.model.entity.VideoBanner;

import java.util.List;

/**
 * 功能描述：视频课程服务接口
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
public interface VideoService {

    /**
     * 获取轮播
     * @param num 获取的条数
     * @return videoBanner列表
     */
    List<VideoBanner> listVideoBanners(int num);

    /**
     * 获取分页视频列表
     * @param pageNum 获取第几页，页数从1开始
     * @param pageSize 每一页的条数，当值为0时，默认查出所有数据
     * @return PageInfo对象
     */
    List<Video> listVideos(int pageNum, int pageSize);

    /**
     * 获取视频详情
     * @param videoId 视频ID
     * @return 视频对象，包含chapterList内容
     */
    Video findVideoDetailById(int videoId);
}
