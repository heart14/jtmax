package xyz.sadli.query.permission;

/**
 * About:
 * Other:
 * Created: wfli on 2022/12/30 11:31.
 * Editored:
 */
public class SavePermissionQuery {

    private String permName;

    private String permDesc;

    private String permType;

    private String permRoute;

    private String permIndex;

    private String permKey;

    private String parentId;

    private Integer status;

    public SavePermissionQuery() {
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType;
    }

    public String getPermRoute() {
        return permRoute;
    }

    public void setPermRoute(String permRoute) {
        this.permRoute = permRoute;
    }

    public String getPermIndex() {
        return permIndex;
    }

    public void setPermIndex(String permIndex) {
        this.permIndex = permIndex;
    }

    public String getPermKey() {
        return permKey;
    }

    public void setPermKey(String permKey) {
        this.permKey = permKey;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SavePermissionQuery{" +
                "permName='" + permName + '\'' +
                ", permDesc='" + permDesc + '\'' +
                ", permType='" + permType + '\'' +
                ", permRoute='" + permRoute + '\'' +
                ", permIndex='" + permIndex + '\'' +
                ", permKey='" + permKey + '\'' +
                ", parentId='" + parentId + '\'' +
                ", status=" + status +
                '}';
    }
}
