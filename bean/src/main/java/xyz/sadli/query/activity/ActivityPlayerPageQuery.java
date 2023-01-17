package xyz.sadli.query.activity;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/17 16:56.
 * Editored:
 */
public class ActivityPlayerPageQuery {

    private int page;

    private int limit;

    private String activityId;

    private String activityName;

    private String nickname;

    private Integer status;

    public ActivityPlayerPageQuery() {
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ActivityPlayerPageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", activityId='" + activityId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", status=" + status +
                '}';
    }
}
