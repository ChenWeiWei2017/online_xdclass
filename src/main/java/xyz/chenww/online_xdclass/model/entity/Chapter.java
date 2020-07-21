package xyz.chenww.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 功能描述：章
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@Data
public class Chapter {

    private Integer id;

    @JsonProperty("video_id")
    private Integer videoId;

    private String title;

    private Integer ordered;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;

    @JsonProperty("episode_list")
    private List<Episode> episodeList;
}
