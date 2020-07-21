package xyz.chenww.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述：首页轮播实体类
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@Data
public class VideoBanner {

    private Integer id;

    private String url;

    private String img;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;

    private Integer weight;
}
