package xyz.chenww.online_xdclass.service.impl;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import xyz.chenww.online_xdclass.domain.User;
import xyz.chenww.online_xdclass.form.UserRegisterForm;
import xyz.chenww.online_xdclass.mapper.UserMapper;
import xyz.chenww.online_xdclass.service.UserService;
import xyz.chenww.online_xdclass.utils.CommonUtil;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(UserRegisterForm userInfo) throws DuplicateKeyException {
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
}
