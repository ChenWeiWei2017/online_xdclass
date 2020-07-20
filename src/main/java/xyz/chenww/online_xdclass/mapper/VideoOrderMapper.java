package xyz.chenww.online_xdclass.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.chenww.online_xdclass.model.entity.VideoOrder;

import java.util.List;

/**
 * 功能描述：视频订单
 *
 * @author chenweiwei
 * @since 2020/7/9
 */
public interface VideoOrderMapper {

    VideoOrder findByUserIdAndVideoIdAndState(Integer userId, Integer videoId, Integer state);

    void save(VideoOrder videoOrder);

    @Select("select * from video_order where user_id = #{userId} order by create_time desc")
    List<VideoOrder> findByUserId(Integer userId);
}
