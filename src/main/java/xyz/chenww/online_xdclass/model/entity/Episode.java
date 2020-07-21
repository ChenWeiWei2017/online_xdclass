package xyz.chenww.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述：集
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@Data
public class Episode {

    private Integer id;

    private String title;

    // 在整个视频课程内的全局排序
    private Integer num;

    // 章内排序
    private Integer ordered;

    // 视频播放地址
    @JsonProperty("play_url")
    private String playUrl;

    @JsonProperty("chapter_id")
    private Integer chapterId;

    private Short free;

    @JsonProperty("video_id")
    private Integer videoId;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;

}
