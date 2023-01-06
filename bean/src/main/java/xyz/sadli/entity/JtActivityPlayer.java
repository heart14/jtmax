package xyz.sadli.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/6 11:18.
 * Editored:
 */
public class JtActivityPlayer implements Serializable {

    private static final long serialVersionUID = -9210913806898331485L;

    private String id;

    private String activityId;

    private String uid;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public JtActivityPlayer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "JtActivityPlayer{" +
                "id='" + id + '\'' +
                ", activityId='" + activityId + '\'' +
                ", uid='" + uid + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
