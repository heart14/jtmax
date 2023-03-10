package xyz.sadli.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import xyz.sadli.entity.JtPhoto;
import xyz.sadli.entity.JtStorage;

import java.io.Serializable;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: wfli on 2023/3/10 15:23.
 * Editored:
 */
public class JtPhotoVO implements Serializable {

    private static final long serialVersionUID = -6236608441284362316L;

    private String photoId;

    private String storageId;

    private String originName;

    private String description;

    private Integer deleteStatus;

    private Integer likesNumber;

    private Integer dlNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String storageName;

    private String size;

    private String storagePath;

    private String networkUrl;

    private String mediaType;

    private Integer resourceType;

    private String creator;

    private Integer fileStatus;

    public JtPhotoVO() {
    }

    public JtPhotoVO(JtPhoto photo, JtStorage storage) {
        this.photoId = photo.getPhotoId();
        this.storageId = photo.getStorageId();
        this.originName = photo.getOriginName();
        this.description = photo.getDescription();
        this.deleteStatus = photo.getDeleteStatus();
        this.likesNumber = photo.getLikesNumber();
        this.dlNumber = photo.getDlNumber();
        this.createTime = photo.getCreateTime();
        this.updateTime = photo.getUpdateTime();
        this.storageName = storage.getStorageName();
        this.size = storage.getSize();
        this.storagePath = storage.getStoragePath();
        this.networkUrl = storage.getNetworkUrl();
        this.mediaType = storage.getMediaType();
        this.resourceType = storage.getResourceType();
        this.creator = storage.getCreator();
        this.fileStatus = storage.getStatus();
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
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

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(Integer likesNumber) {
        this.likesNumber = likesNumber;
    }

    public Integer getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(Integer dlNumber) {
        this.dlNumber = dlNumber;
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

    @Override
    public String toString() {
        return "JtPhotoVO{" +
                "photoId='" + photoId + '\'' +
                ", storageId='" + storageId + '\'' +
                ", originName='" + originName + '\'' +
                ", description='" + description + '\'' +
                ", deleteStatus='" + deleteStatus + '\'' +
                ", likesNumber=" + likesNumber +
                ", dlNumber=" + dlNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", storageName='" + storageName + '\'' +
                ", size='" + size + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", networkUrl='" + networkUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", resourceType=" + resourceType +
                ", creator='" + creator + '\'' +
                ", fileStatus=" + fileStatus +
                '}';
    }
}
