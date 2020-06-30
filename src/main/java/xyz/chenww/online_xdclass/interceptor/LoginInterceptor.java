package xyz.chenww.online_xdclass.interceptor;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import xyz.chenww.online_xdclass.utils.CommonUtil;
import xyz.chenww.online_xdclass.utils.JWTUtil;
import xyz.chenww.online_xdclass.utils.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述：请求拦截器，判断是否登录
 *
 * @author chenweiwei
 * @since 2020/6/30
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String token = request.getHeader("token");
            if (token == null) {
                token = request.getParameter("token");
            }

            if (StringUtils.isNotBlank(token)) {
                Claims claims = JWTUtil.checkJWT(token);
                if (claims == null) {
                    // 凭据无效或过期
                    CommonUtil.sendJsonMessage(response, JsonData.buildByStatus(JsonData.Status.INVALID_LOGIN_STATUS, "登录过期，请重新登录"));
                    return false;
                }

                // 将token中解析出来的用户信息放到request中传递给后端
                Integer userId = (Integer) claims.get("user_id");
                String username = (String) claims.get("username");
                String headImg = (String) claims.get("head_img");
                request.setAttribute("user_id", userId);
                request.setAttribute("username", username);
                request.setAttribute("head_img", headImg);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CommonUtil.sendJsonMessage(response, JsonData.buildByStatus(JsonData.Status.INVALID_LOGIN_STATUS, "用户未登录"));
        return false;
    }
}
