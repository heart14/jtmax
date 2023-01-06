package xyz.sadli.query.activity;

/**
 * About: 分页查询活动信息参数
 * Other:
 * Created: wfli on 2023/1/6 11:28.
 * Editored:
 */
public class ActivityPageQuery {

    private int page;

    private int limit;

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

    @Override
    public String toString() {
        return "ActivityPageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
