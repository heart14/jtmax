package xyz.sadli.entity;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/28 23:03.
 * Editored:
 */
public class JtRolePermission {

    private String roleId;

    private String permId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }
}
