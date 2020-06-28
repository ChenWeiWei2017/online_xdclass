package xyz.chenww.online_xdclass.controller;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.chenww.online_xdclass.form.UserRegisterForm;
import xyz.chenww.online_xdclass.service.UserService;
import xyz.chenww.online_xdclass.utils.JsonData;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @PostMapping("register")
    public JsonData register(@Validated @RequestBody(required = false) UserRegisterForm userInfo, BindingResult errors) {
        if (userInfo == null) {
            return JsonData.buildByStatus(JsonData.Status.BAD_REQUEST, "用户信息不能为空");
        }
        // 参数校验结果分析，返回错误信息
        if (errors.hasErrors()) {
            return JsonData.buildByStatus(JsonData.Status.BAD_REQUEST, errors.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            userService.addUser(userInfo);
        } catch (DuplicateKeyException e) {
            return JsonData.buildByStatus(JsonData.Status.BAD_REQUEST, "用户名或手机号已存在");
        }
        return JsonData.buildSuccess(null);
    }
}
