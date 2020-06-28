package xyz.chenww.online_xdclass.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户注册表单
 */
@Data
public class UserRegisterForm {

    @NotBlank(message = "用户名不能为空")
    // 长度校验
    @Size(min = 2, max = 16, message = "用户名长度必须在2~16个以内")
    private String username;

    @NotBlank(message = "密码不能为空")
    // 正则校验
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@!%*?&])[A-Za-z\\d$@!%*?&]{8,16}$", message = "密码长度必须在6~18个以内，且包含大小写字母、数字和特殊字符")
    private String password;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1](([3][0-9])|([4][0-1,4-9])|([5][0-3,5-9])|([6][2,5-7])|([7][0-8])|([8][0-9])|([9][0-3,5-9]))[0-9]{8}$", message = "手机号格式错误")
    private String phone;

}
