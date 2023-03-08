package xyz.sadli.entity;

import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/3/8 20:49.
 * Editored:
 */
public class JtBanner {

    private String bannerId;

    private String storageId;

    private String originName;

    private String description;

    private Integer showStatus;

    private Date createTime;

    private Date updateTime;

    public JtBanner() {
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId == null ? null : bannerId.trim();
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId == null ? null : storageId.trim();
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName == null ? null : originName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
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
        return "JtBanner{" +
                "bannerId='" + bannerId + '\'' +
                ", storageId='" + storageId + '\'' +
                ", originName='" + originName + '\'' +
                ", description='" + description + '\'' +
                ", showStatus=" + showStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
