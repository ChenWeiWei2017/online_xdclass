package xyz.chenww.online_xdclass.model.entity;

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

    private String headImg;

    private String phone;

    private Date createTime;
}
