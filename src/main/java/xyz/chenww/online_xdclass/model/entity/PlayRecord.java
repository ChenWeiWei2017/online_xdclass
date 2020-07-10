package xyz.chenww.online_xdclass.model.entity;

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

    private Integer userId;

    private Integer videoId;

    /** 当前播放第几集 */
    private Integer currentNum;

    /** 当前播放集Id */
    private Integer episodeId;

    private Date createTime;
}
