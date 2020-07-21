package xyz.chenww.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("out_trade_no")
    private String outTradeNo;

    private Integer state;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;

    @JsonProperty("total_fee")
    private Integer totalFee;

    @JsonProperty("video_id")
    private Integer videoId;

    @JsonProperty("user_id")
    private Integer userId;

    // 冗余字段，减少联表查询，提高查询效率
    @JsonProperty("video_title")
    private String videoTitle;

    // 冗余字段
    @JsonProperty("video_img")
    private String videoImg;
}
