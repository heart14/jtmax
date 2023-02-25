package xyz.sadli.query.activity;

import xyz.sadli.query.BasePageQuery;

import java.util.Date;

/**
 * About: 分页查询活动信息参数
 * Other:
 * Created: wfli on 2023/1/6 11:28.
 * Editored:
 */
public class ActivityPageQuery extends BasePageQuery {

    private String activityName;

    private String activityType;

    private Integer status;

    private Date assembleDateStart;

    private Date assembleDateEnd;

    public ActivityPageQuery() {
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAssembleDateStart() {
        return assembleDateStart;
    }

    public void setAssembleDateStart(Date assembleDateStart) {
        this.assembleDateStart = assembleDateStart;
    }

    public Date getAssembleDateEnd() {
        return assembleDateEnd;
    }

    public void setAssembleDateEnd(Date assembleDateEnd) {
        this.assembleDateEnd = assembleDateEnd;
    }

    @Override
    public String toString() {
        return "ActivityPageQuery{" +
                "activityName='" + activityName + '\'' +
                ", activityType='" + activityType + '\'' +
                ", status=" + status +
                ", assembleDateStart=" + assembleDateStart +
                ", assembleDateEnd=" + assembleDateEnd +
                '}';
    }
}
