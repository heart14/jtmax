package xyz.sadli.query.activity;

import java.util.Date;

/**
 * About: 分页查询活动信息参数
 * Other:
 * Created: wfli on 2023/1/6 11:28.
 * Editored:
 */
public class ActivityPageQuery {

    private int page;

    private int limit;

    private String activityName;

    private String activityType;

    private Integer status;

    private Date activityDateStart;

    private Date activityDateEnd;

    public ActivityPageQuery() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    public Date getActivityDateStart() {
        return activityDateStart;
    }

    public void setActivityDateStart(Date activityDateStart) {
        this.activityDateStart = activityDateStart;
    }

    public Date getActivityDateEnd() {
        return activityDateEnd;
    }

    public void setActivityDateEnd(Date activityDateEnd) {
        this.activityDateEnd = activityDateEnd;
    }

    @Override
    public String toString() {
        return "ActivityPageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", activityName='" + activityName + '\'' +
                ", activityType='" + activityType + '\'' +
                ", status=" + status +
                ", activityDateStart=" + activityDateStart +
                ", activityDateEnd=" + activityDateEnd +
                '}';
    }
}
