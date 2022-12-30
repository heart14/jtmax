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

    private String permType;

    private String permName;

    /**
     * 为什么这里用Integer，而上面page limit可以用int？
     * 因为这个参数不是必传的，它可以为null，xml里面的sql上也会判断如果status为null则不对该条件进行筛选
     * 而page limit分页参数是必传的，所以可以用int类型
     */
    private Integer status;


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

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PermissionPageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", permType='" + permType + '\'' +
                ", permName='" + permName + '\'' +
                ", status=" + status +
                '}';
    }
}
