package xyz.chenww.online_xdclass.model.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 功能描述：章
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@Data
public class Chapter {

    private Integer id;

    private Integer videoId;

    private String title;

    private Integer ordered;

    private Date createTime;

    private List<Episode> episodeList;
}
