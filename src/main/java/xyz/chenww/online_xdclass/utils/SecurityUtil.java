package xyz.chenww.online_xdclass.utils;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
@Slf4j
public class SecurityUtil {

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


}
