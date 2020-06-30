package xyz.chenww.online_xdclass.service;

import org.springframework.dao.DuplicateKeyException;
import xyz.chenww.online_xdclass.model.request.RegisterRequest;

public interface UserService {

    /**
     * 新增用户
     * @throws DuplicateKeyException 唯一键重复异常，只抛出处理这一个异常，其他异常由全局异常处理器进行处理
     */
    void addUser(RegisterRequest userInfo) throws DuplicateKeyException;
}
