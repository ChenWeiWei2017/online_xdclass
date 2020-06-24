package xyz.chenww.online_xdclass.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import xyz.chenww.online_xdclass.domain.Video;
import xyz.chenww.online_xdclass.domain.VideoBanner;
import xyz.chenww.online_xdclass.service.VideoService;
import xyz.chenww.online_xdclass.utils.JsonData;

import java.util.List;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoPubController {

    private final VideoService videoService;

    public VideoPubController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("banner/list")
    public JsonData listBanner(@RequestParam(value = "num", required = false, defaultValue = "5") int num) {
        List<VideoBanner> videoBanners = videoService.listVideoBanners(num);
        return JsonData.buildSuccess(videoBanners);
    }

    @GetMapping("list")
    public JsonData listVideo(@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "0") int pageSize) {
        List<Video> videoList = videoService.listVideos(pageNum, pageSize);
        return JsonData.buildSuccess(new PageInfo<>(videoList));
    }

    @GetMapping("detail/{videoId}")
    public JsonData findVideoDetail(@PathVariable int videoId) {
        return JsonData.buildSuccess(videoService.findVideoDetailById(videoId));
    }

}
