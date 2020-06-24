package xyz.chenww.online_xdclass.domain;

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

    private String coverImg;

    private Integer price;

    private Date createTime;

    private Double point;

    private List<Chapter> chapterList;
}
