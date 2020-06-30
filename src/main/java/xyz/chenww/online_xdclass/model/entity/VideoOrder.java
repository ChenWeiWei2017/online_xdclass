package xyz.chenww.online_xdclass.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@Data
public class VideoOrder {

    private Integer id;

    private String outTradeNo;

    private Integer state;

    private Date createTime;

    private Integer totalFee;

    private Integer videoId;

    private Integer userId;

    // 冗余字段，减少联表查询，提高查询效率
    private String videoTitle;

    // 冗余字段
    private String videoImg;
}
