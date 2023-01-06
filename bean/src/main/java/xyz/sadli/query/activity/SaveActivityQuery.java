package xyz.sadli.query.activity;

import java.util.Date;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/6 14:04.
 * Editored:
 */
public class SaveActivityQuery {

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

    private String remark;

    public SaveActivityQuery() {
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
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
        this.assemblePlace = assemblePlace;
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public String getActivityOrganizer() {
        return activityOrganizer;
    }

    public void setActivityOrganizer(String activityOrganizer) {
        this.activityOrganizer = activityOrganizer;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SaveActivityQuery{" +
                "activityName='" + activityName + '\'' +
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
                ", remark='" + remark + '\'' +
                '}';
    }
}
