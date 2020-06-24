package xyz.chenww.online_xdclass.utils;

/**
 * 功能描述：接口数据统一返回结构
 *
 * @author chenweiwei
 * @since 2020/5/21
 */
public class JsonData {

    private int code;

    private Object data;

    private String msg;

    public JsonData() {}

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static JsonData buildSuccess(Object data) {
        return new JsonData(Status.SUCCESS.getStatusCode(), data);
    }

    public static JsonData buildError(String msg) {
        return new JsonData(Status.INTERNAL_SERVER_ERROR.getStatusCode(), null, msg);
    }

    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }

    public static JsonData buildByStatus(Status status) {
        return new JsonData(status.getStatusCode(), null, status.getStatusName());
    }

    public static JsonData buildByStatus(Status status, String msg) {
        return new JsonData(status.getStatusCode(), null, msg);
    }

    public static JsonData buildByStatus(Status status, Object data) {
        return new JsonData(status.getStatusCode(), data, status.getStatusName());
    }

    public static JsonData buildByStatus(Status status, Object data, String msg) {
        return new JsonData(status.getStatusCode(), data, msg);
    }

    /**
     * 状态码定义
     * 对应用的状态码进行统一管理
     */
    public enum Status {

        SUCCESS(200, "操作成功"),
        BAD_REQUEST(400, "请求参数或格式错误"),
        NOT_FOUND(404, "404 Not Found"),
        INTERNAL_SERVER_ERROR(500, "服务器异常"),
        LOGIN_FAILED(-1, "用户登录失败，用户名或密码错误"),
        INVALID_LOGIN_STATUS(401, "登录状态失效"),
        NOT_LOGIN(402, "用户未登录"),
        NO_ACCESS(403, "无权访问"),
        // API是POST 而请求用GET(或其他)请求
        METHOD_NOT_ALLOWED(405, "HTTP谓词不被允许"),
        ;


        private int statusCode;
        private String statusName;

        Status(int statusCode, String statusName) {
            this.statusCode = statusCode;
            this.statusName = statusName;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
