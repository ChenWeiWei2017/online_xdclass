package xyz.chenww.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述：用户实体类
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String pwd;

    @JsonProperty("head_img")
    private String headImg;

    private String phone;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private Date createTime;
}
