package xyz.chenww.online_xdclass.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.chenww.online_xdclass.model.request.VideoOrderRequest;
import xyz.chenww.online_xdclass.service.OrderService;
import xyz.chenww.online_xdclass.utils.JsonData;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：下单请求API控制器
 *
 * @author chenweiwei
 * @since 2020/7/9
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

    private final OrderService orderService;

    public VideoOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public JsonData saveOrder(@Validated @RequestBody VideoOrderRequest orderRequest, HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        int result = orderService.save(userId, orderRequest.getVideoId());
        return result == 1 ? JsonData.buildSuccess(null) : JsonData.buildByStatus(JsonData.Status.OPERATE_FAILED);
    }
}
