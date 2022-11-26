package xyz.sadli.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/11/20 11:31.
 * Editored:
 */
public class JtLog implements Serializable {

    private static final long serialVersionUID = 3138690365969963567L;

    private String logId;

    private String uid;

    private String traceId;

    private String ip;

    private String method;

    private String path;

    private String resource;

    private String params;

    private Date logTime;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId == null ? null : traceId.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    @Override
    public String toString() {
        return "JtLog{" +
                "logId='" + logId + '\'' +
                ", uid='" + uid + '\'' +
                ", traceId='" + traceId + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", resource='" + resource + '\'' +
                ", params='" + params + '\'' +
                ", logTime=" + logTime +
                '}';
    }
}