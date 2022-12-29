package xyz.sadli.query.permission;

/**
 * About:
 * Other:
 * Created: wfli on 2022/12/29 16:21.
 * Editored:
 */
public class PermissionPageQuery {

    private int page;

    private int limit;


    public PermissionPageQuery() {
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
        return "PermissionPageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
