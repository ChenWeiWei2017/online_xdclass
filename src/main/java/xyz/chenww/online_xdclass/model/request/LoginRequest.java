package xyz.chenww.online_xdclass.model.request;

import lombok.Data;

/**
 * 功能描述：登录信息，使用手机号和密码登录
 * 后续可以加验证码之类的
 *
 * @author chenweiwei
 * @since 2020/6/30
 */
@Data
public class LoginRequest {

    private String phone;

    private String password;
}
