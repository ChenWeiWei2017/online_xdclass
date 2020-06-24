package xyz.chenww.online_xdclass.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.chenww.online_xdclass.domain.Video;

import java.util.List;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
public interface VideoMapper {

    @Select("select * from video where id = #{id}")
    Video findById(Integer id);

    @Select("select * from video")
    List<Video> findAll();

    Video findDetailById(Integer id);
}
