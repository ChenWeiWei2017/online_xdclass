package xyz.chenww.online_xdclass.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.chenww.online_xdclass.model.entity.VideoBanner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
@SpringBootTest
@Slf4j
public class VideoBannerMapperTest {

    @Resource
    private VideoBannerMapper videoBannerMapper;

    @Test
    public void testFindBanners() {
        int num = 3;
        List<VideoBanner> banners = videoBannerMapper.findBanners(num);
        log.info(banners.toString());
    }
}
