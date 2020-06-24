package xyz.chenww.online_xdclass.domain;

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

    private Date createTime;

    private Integer weight;
}
