package xyz.sadli.vo;

import java.io.Serializable;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:14.
 * Editored:
 */
public class SysResponse implements Serializable {

    private static final long serialVersionUID = -1208864543584339177L;

    /**
     * 状态值：SUCCESS|FAIL
     */
    private String state;

    private Integer code;

    private String msg;

    private String traceId;

    private Object data;

    public SysResponse() {
    }

    public SysResponse(String state, Integer code, String msg, Object data, String traceId) {
        this.state = state;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.traceId = traceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SysResponse{" +
                "state='" + state + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", traceId='" + traceId + '\'' +
                ", data=" + data +
                '}';
    }
}