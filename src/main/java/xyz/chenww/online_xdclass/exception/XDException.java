package xyz.chenww.online_xdclass.exception;

/**
 * 功能描述：自定义异常
 *
 * @author chenweiwei
 * @since 2020/6/24
 */
public class XDException extends RuntimeException {

    private Integer code;

    private String msg;

    public XDException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
