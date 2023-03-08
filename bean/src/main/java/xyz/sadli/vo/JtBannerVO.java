package xyz.sadli.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import xyz.sadli.entity.JtBanner;
import xyz.sadli.entity.JtStorage;

import java.io.Serializable;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/3/8 20:56.
 * Editored:
 */
public class JtBannerVO implements Serializable {

    private static final long serialVersionUID = -8091375465951787890L;

    private String bannerId;

    private String storageId;

    private String originName;

    private String description;

    private Integer showStatus;

    private String storageName;

    private String size;

    private String storagePath;

    private String networkUrl;

    private String mediaType;

    private Integer resourceType;

    private String creator;

    private Integer fileStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public JtBannerVO() {
    }

    public JtBannerVO(JtBanner banner, JtStorage storage) {
        this.bannerId = banner.getBannerId();
        this.storageId = banner.getStorageId();
        this.originName = banner.getOriginName();
        this.description = banner.getDescription();
        this.showStatus = banner.getShowStatus();
        this.storageName = storage.getStorageName();
        this.size = storage.getSize();
        this.storagePath = storage.getStoragePath();
        this.networkUrl = storage.getNetworkUrl();
        this.mediaType = storage.getMediaType();
        this.resourceType = storage.getResourceType();
        this.creator = storage.getCreator();
        this.fileStatus = storage.getStatus();
        this.createTime = banner.getCreateTime();
        this.updateTime = banner.getUpdateTime();
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public String getNetworkUrl() {
        return networkUrl;
    }

    public void setNetworkUrl(String networkUrl) {
        this.networkUrl = networkUrl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
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
        return "JtBannerVO{" +
                "bannerId='" + bannerId + '\'' +
                ", storageId='" + storageId + '\'' +
                ", originName='" + originName + '\'' +
                ", description='" + description + '\'' +
                ", showStatus=" + showStatus +
                ", storageName='" + storageName + '\'' +
                ", size='" + size + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", networkUrl='" + networkUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", resourceType=" + resourceType +
                ", creator='" + creator + '\'' +
                ", fileStatus=" + fileStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
