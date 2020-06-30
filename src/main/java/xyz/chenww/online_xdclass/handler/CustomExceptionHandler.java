package xyz.chenww.online_xdclass.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.chenww.online_xdclass.exception.XDException;
import xyz.chenww.online_xdclass.utils.JsonData;

/**
 * 功能描述：全局异常处理
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public JsonData handleMissingArgument(HttpMessageNotReadableException e) {
        log.error("请求缺少参数：{}", e.getMessage());
        return JsonData.buildByStatus(JsonData.Status.BAD_REQUEST, "缺少必要参数");
    }

    @ExceptionHandler(value = Exception.class)
    public JsonData handle(Exception e) {
        log.error("[系统异常]{}", e.getMessage(), e);
        if (e instanceof XDException) {
            XDException xdException = (XDException) e;
            return JsonData.buildError(xdException.getCode(), xdException.getMsg());
        }
        return JsonData.buildError("全局异常，未知错误");
    }
}
