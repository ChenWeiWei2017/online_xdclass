package xyz.chenww.online_xdclass.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.chenww.online_xdclass.model.entity.VideoBanner;

import java.util.List;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
public interface VideoBannerMapper {

    @Select("select * from video_banner order by weight asc limit #{num}")
    List<VideoBanner> findBanners(int num);
}
