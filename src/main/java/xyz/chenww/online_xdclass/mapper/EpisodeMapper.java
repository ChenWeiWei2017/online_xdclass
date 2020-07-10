package xyz.chenww.online_xdclass.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.chenww.online_xdclass.model.entity.Episode;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/7/10
 */
public interface EpisodeMapper {

    /**
     * 根据视频id及集数获取具体的某一集信息
     * @param videoId 所属视频id
     * @param num 视频内全局第几集
     */
    @Select("select * from episode where video_id = #{videoId} and num = #{num}")
    Episode findByVideoIdAndNum(Integer videoId, Integer num);
}
