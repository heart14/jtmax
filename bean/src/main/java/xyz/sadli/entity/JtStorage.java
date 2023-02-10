package xyz.sadli.entity;

import java.util.Date;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/10 14:02.
 * Editored:
 */
public class JtStorage {

    private String id;

    private String originName;

    private String storageName;

    private String description;

    private String size;

    private String storagePath;

    private String networkUrl;

    private String mediaType;

    private Integer resourceType;

    private String creator;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public JtStorage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName == null ? null : originName.trim();
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName == null ? null : storageName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath == null ? null : storagePath.trim();
    }

    public String getNetworkUrl() {
        return networkUrl;
    }

    public void setNetworkUrl(String networkUrl) {
        this.networkUrl = networkUrl == null ? null : networkUrl.trim();
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType == null ? null : mediaType.trim();
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
        this.creator = creator == null ? null : creator.trim();
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
        return "JtStorage{" +
                "id='" + id + '\'' +
                ", originName='" + originName + '\'' +
                ", storageName='" + storageName + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", networkUrl='" + networkUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", resourceType=" + resourceType +
                ", creator='" + creator + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
