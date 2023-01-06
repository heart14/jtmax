package xyz.sadli.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/6 11:16.
 * Editored:
 */
public class JtActivity implements Serializable {

    private static final long serialVersionUID = 2496602334265759821L;

    private String activityId;

    private String activityName;

    private String activityDesc;

    private Date activityTimeStart;

    private Date activityTimeEnd;

    private Date assembleTime;

    private String assemblePlace;

    private String activityPlace;

    private String activityOrganizer;

    private Integer minLevel;

    private Integer maxPlayer;

    private Date deadline;

    private String status;

    private String remark;

    public JtActivity() {
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc == null ? null : activityDesc.trim();
    }

    public Date getActivityTimeStart() {
        return activityTimeStart;
    }

    public void setActivityTimeStart(Date activityTimeStart) {
        this.activityTimeStart = activityTimeStart;
    }

    public Date getActivityTimeEnd() {
        return activityTimeEnd;
    }

    public void setActivityTimeEnd(Date activityTimeEnd) {
        this.activityTimeEnd = activityTimeEnd;
    }

    public Date getAssembleTime() {
        return assembleTime;
    }

    public void setAssembleTime(Date assembleTime) {
        this.assembleTime = assembleTime;
    }

    public String getAssemblePlace() {
        return assemblePlace;
    }

    public void setAssemblePlace(String assemblePlace) {
        this.assemblePlace = assemblePlace == null ? null : assemblePlace.trim();
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace == null ? null : activityPlace.trim();
    }

    public String getActivityOrganizer() {
        return activityOrganizer;
    }

    public void setActivityOrganizer(String activityOrganizer) {
        this.activityOrganizer = activityOrganizer == null ? null : activityOrganizer.trim();
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(Integer maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "JtActivity{" +
                "activityId='" + activityId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", activityTimeStart=" + activityTimeStart +
                ", activityTimeEnd=" + activityTimeEnd +
                ", assembleTime=" + assembleTime +
                ", assemblePlace='" + assemblePlace + '\'' +
                ", activityPlace='" + activityPlace + '\'' +
                ", activityOrganizer='" + activityOrganizer + '\'' +
                ", minLevel=" + minLevel +
                ", maxPlayer=" + maxPlayer +
                ", deadline=" + deadline +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
