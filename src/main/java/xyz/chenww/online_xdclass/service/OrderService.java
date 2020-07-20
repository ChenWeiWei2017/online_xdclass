package xyz.chenww.online_xdclass.service;

import xyz.chenww.online_xdclass.model.entity.VideoOrder;

import java.util.List;

/**
 * 功能描述：
 *
 * @author chenweiwei
 * @since 2020/7/9
 */
public interface OrderService {

    int save(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(Integer userId);
}
