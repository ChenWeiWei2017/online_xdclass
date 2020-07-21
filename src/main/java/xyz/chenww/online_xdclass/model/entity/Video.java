package xyz.chenww.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 功能描述：视频实体类
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@Data
public class Video {

    private Integer id;

    private String title;

    private String summary;

    @JsonProperty("cover_img")
    private String coverImg;

    private Integer price;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;

    private Double point;

    @JsonProperty("chapter_list")
    private List<Chapter> chapterList;
}
