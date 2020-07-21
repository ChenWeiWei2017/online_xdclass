package xyz.chenww.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述：视频播放记录
 *
 * @author chenweiwei
 * @since 2020/7/10
 */
@Data
public class PlayRecord {

    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("video_id")
    private Integer videoId;

    /** 当前播放第几集 */
    @JsonProperty("current_num")
    private Integer currentNum;

    /** 当前播放集Id */
    @JsonProperty("episode_id")
    private Integer episodeId;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;
}
