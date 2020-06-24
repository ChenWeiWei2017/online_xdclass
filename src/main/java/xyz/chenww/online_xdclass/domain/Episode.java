package xyz.chenww.online_xdclass.domain;

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
    private String playUrl;

    private Integer chapterId;

    private Short free;

    private Integer videoId;

    private Date createTime;

}
