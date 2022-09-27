package xyz.sadli.vo;

import java.io.Serializable;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:14.
 * Editored:
 */
public class SysRequest implements Serializable {

    private static final long serialVersionUID = -3026896682454037934L;

    private String ver;

    private String sign;

    private Long timestamp;

    private String cmd;

    private Object biz;

    public SysRequest() {
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Object getBiz() {
        return biz;
    }

    public void setBiz(Object biz) {
        this.biz = biz;
    }

    @Override
    public String toString() {
        return "SysRequest{" +
                "ver='" + ver + '\'' +
                ", sign='" + sign + '\'' +
                ", timestamp=" + timestamp +
                ", cmd='" + cmd + '\'' +
                ", biz=" + biz +
                '}';
    }
}
