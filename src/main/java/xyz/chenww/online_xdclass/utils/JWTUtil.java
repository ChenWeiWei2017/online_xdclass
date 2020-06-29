package xyz.chenww.online_xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import xyz.chenww.online_xdclass.domain.User;

import java.util.Date;

/**
 * JWT工具类
 * 注意点：
 * 1、生成的Token是可以通过Base64算法解密出明文信息的（claim中设置的信息）
 * 2、base64解密出的明文信息，修改后再进行编码，则会解密失败（因为不知道密匙）
 * 3、无法作废已颁布的token，除非更改密钥
 */
public class JWTUtil {

    /**
     * 过期时间，3天后过期
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 3;

    /**
     * 设置密匙
     */
    private static final String SECRET_KEY = "chenweiwei.project.xdclass.20200629";

    /**
     * 设置主题
     */
    private static final String SUBJECT = "xdclass";

    /**
     * 生成Token
     * @param user 用户信息
     * @return Token串
     */
    public static String geneJsonWebToken(User user) {
        return Jwts.builder().setSubject(SUBJECT)
                .claim("user_id", user.getId())
                .claim("username", user.getName())
                .claim("head_img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * 校验Token
     */
    public static Claims checkJWT(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // 抛出异常说明校验失败
            return null;
        }
    }
}
