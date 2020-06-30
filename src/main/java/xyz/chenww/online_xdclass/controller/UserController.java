package xyz.chenww.online_xdclass.controller;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.chenww.online_xdclass.model.entity.User;
import xyz.chenww.online_xdclass.model.request.LoginRequest;
import xyz.chenww.online_xdclass.model.request.RegisterRequest;
import xyz.chenww.online_xdclass.service.UserService;
import xyz.chenww.online_xdclass.utils.JWTUtil;
import xyz.chenww.online_xdclass.utils.JsonData;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @PostMapping("register")
    public JsonData register(@Validated @RequestBody RegisterRequest userInfo, BindingResult errors) {
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

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        User loginUser = userService.loginCheck(loginRequest);
        if (loginUser != null) {
            // 登录成功，返回token
            String token = JWTUtil.geneJsonWebToken(loginUser);
            return JsonData.buildSuccess(token);
        }
        return JsonData.buildByStatus(JsonData.Status.LOGIN_FAILED);
    }

    /**
     * 获取个人信息
     */
    @GetMapping("info")
    public JsonData info(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        String username = (String) request.getAttribute("username");
        String headImg = (String) request.getAttribute("head_img");
        Map<String, Object> result = new HashMap<>();
        result.put("user_id", userId);
        result.put("username", username);
        result.put("head_img", headImg);
        return JsonData.buildSuccess(result);
    }
}
