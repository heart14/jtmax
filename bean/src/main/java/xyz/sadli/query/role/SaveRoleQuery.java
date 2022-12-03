package xyz.sadli.query.role;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/3 22:08.
 * Editored:
 */
public class SaveRoleQuery {

    private String roleKey;

    private String roleName;

    private String roleDesc;

    private Object routes;

    public SaveRoleQuery() {
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Object getRoutes() {
        return routes;
    }

    public void setRoutes(Object routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "SaveRoleQuery{" +
                "roleKey='" + roleKey + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", routes=" + routes +
                '}';
    }
}
