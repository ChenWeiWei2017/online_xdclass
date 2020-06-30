package xyz.chenww.online_xdclass.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import xyz.chenww.online_xdclass.model.entity.User;
import xyz.chenww.online_xdclass.mapper.UserMapper;
import xyz.chenww.online_xdclass.model.request.LoginRequest;
import xyz.chenww.online_xdclass.model.request.RegisterRequest;
import xyz.chenww.online_xdclass.service.UserService;
import xyz.chenww.online_xdclass.utils.CommonUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(RegisterRequest userInfo) throws DuplicateKeyException {
        // 封装User对象
        User user = new User();
        user.setName(userInfo.getUsername());
        user.setPwd(CommonUtil.MD5(userInfo.getPassword()));
        user.setPhone(userInfo.getPhone());
        user.setCreateTime(new Date());
        user.setHeadImg(CommonUtil.getRandomHeadImg());
        // 存储，如果唯一键重复，则会将异常抛出
        userMapper.addUser(user);
    }

    @Override
    public User loginCheck(LoginRequest loginRequest) {

        if (StringUtils.isBlank(loginRequest.getPhone()) || StringUtils.isBlank(loginRequest.getPassword())) {
            return null;
        }

        User scope = new User();
        scope.setPhone(loginRequest.getPhone());
        scope.setPwd(CommonUtil.MD5(loginRequest.getPassword()));

        List<User> users = userMapper.selectByScope(scope);

        // 查到的数据有且只有一个，则为成功，返回查询到的对象
        return users.size() == 1 ? users.get(0) : null;
    }
}
