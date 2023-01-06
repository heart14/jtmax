package xyz.sadli.entity;

import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/28 22:44.
 * Editored:
 */
public class JtPermission {

    private String permId;

    private String permName;

    private String permDesc;

    private String permType;

    private String permRoute;

    private String permIndex;

    private String permKey;

    private String parentId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public JtPermission() {
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc == null ? null : permDesc.trim();
    }

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType == null ? null : permType.trim();
    }

    public String getPermRoute() {
        return permRoute;
    }

    public void setPermRoute(String permRoute) {
        this.permRoute = permRoute == null ? null : permRoute.trim();
    }

    public String getPermIndex() {
        return permIndex;
    }

    public void setPermIndex(String permIndex) {
        this.permIndex = permIndex == null ? null : permIndex.trim();
    }

    public String getPermKey() {
        return permKey;
    }

    public void setPermKey(String permKey) {
        this.permKey = permKey == null ? null : permKey.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "JtPermission{" +
                "permId='" + permId + '\'' +
                ", permName='" + permName + '\'' +
                ", permDesc='" + permDesc + '\'' +
                ", permType='" + permType + '\'' +
                ", permRoute='" + permRoute + '\'' +
                ", permIndex='" + permIndex + '\'' +
                ", permKey='" + permKey + '\'' +
                ", parentId='" + parentId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
