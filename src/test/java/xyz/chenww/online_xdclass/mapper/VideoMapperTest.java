package xyz.chenww.online_xdclass.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.chenww.online_xdclass.domain.Video;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述：VideoMapper测试
 *
 * @author chenweiwei
 * @since 2020/6/23
 */
@SpringBootTest
@Slf4j
public class VideoMapperTest {

    @Resource
    private VideoMapper videoMapper;

    @Test
    public void testFindById() {
        Video video = videoMapper.findById(31);
        Assertions.assertNotNull(video);
        log.info(video.toString());
    }

    @Test
    public void testFindAll() {
        PageHelper.startPage(1, 10);
        List<Video> videos = videoMapper.findAll();
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        log.info("总数据：" + pageInfo.getTotal());
        log.info("总页数：" + pageInfo.getPages());
        log.info("当前页数：" + pageInfo.getPageNum());
        log.info("当前页数据数：" + pageInfo.getPageSize());
        log.info(pageInfo.getList().toString());
    }

    @Test
    public void testFindDetail() {
        Video video = videoMapper.findDetailById(40);
        System.out.println(video);
    }
}
