package xyz.sadli.vo;

import xyz.sadli.entity.JtPermission;

import java.io.Serializable;
import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/3 21:25.
 * Editored:
 */
public class JtRoleVO implements Serializable {

    private static final long serialVersionUID = -5950183254886095395L;

    private String roleId;

    private String roleName;

    private String roleDesc;

    private String roleKey;

    private String roleIndex;

    private Integer status;

    private List<JtPermission> permissionList;

    public JtRoleVO() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleIndex() {
        return roleIndex;
    }

    public void setRoleIndex(String roleIndex) {
        this.roleIndex = roleIndex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<JtPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<JtPermission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "JtRoleVO{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleKey='" + roleKey + '\'' +
                ", roleIndex='" + roleIndex + '\'' +
                ", status=" + status +
                ", permissionList=" + permissionList +
                '}';
    }
}
