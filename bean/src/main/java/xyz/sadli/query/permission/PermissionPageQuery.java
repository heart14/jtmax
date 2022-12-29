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

    @Override
    public String toString() {
        return "PermissionPageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", permType='" + permType + '\'' +
                ", permName='" + permName + '\'' +
                '}';
    }
}
