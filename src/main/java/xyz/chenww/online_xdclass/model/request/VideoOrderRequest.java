package xyz.chenww.online_xdclass.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 功能描述：订单请求实体类
 *
 * @author chenweiwei
 * @since 2020/7/9
 */
@Data
@NotNull(message = "无视频信息")
public class VideoOrderRequest {

    @JsonProperty("video_id")
    @NotNull(message = "无视频信息")
    private Integer videoId;
}
