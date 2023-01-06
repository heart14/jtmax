package xyz.sadli.entity;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/28 23:03.
 * Editored:
 */
public class JtPlayerRole {

    private String uid;

    private String roleId;

    public JtPlayerRole() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    @Override
    public String toString() {
        return "JtPlayerRole{" +
                "uid='" + uid + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
