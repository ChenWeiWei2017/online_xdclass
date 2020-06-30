package xyz.chenww.online_xdclass.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;

/**
 * 功能描述：通用工具类
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
@Slf4j
public class CommonUtil {

    /**
     * 系统存有的几张头像图片
     */
    private static final String[] HEAD_IMG = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    public static String MD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte item : array) {
                stringBuilder.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return stringBuilder.toString().toUpperCase();
        } catch (Exception e) {
            log.error("MD5加密出错", e);
        }
        return null;
    }

    /**
     * 从系统中的头像图片里随机获取一张
     * @return 图片的URL
     */
    public static String getRandomHeadImg() {
        int randomIndex = new Random().nextInt(HEAD_IMG.length);
        return HEAD_IMG[randomIndex];
    }

    /**
     * 将对象以Json形式传递给前端
     */
    public static void sendJsonMessage(HttpServletResponse response, Object object) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSONString(object));
            writer.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
