package xyz.sadli.query.photo;

import xyz.sadli.query.storage.StorageBasePageQuery;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/2/26 0:39.
 * Editored:
 */
public class PhotoPageQuery extends StorageBasePageQuery {

    // 图库的resourceType值固定为1
    private Integer resourceType = 1;

    // 图片状态
    private Integer deleteStatus;

    // 点赞数
    private Integer likesNumber;

    // 下载数
    private Integer dlNumber;

    public PhotoPageQuery() {
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
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

    @Override
    public String toString() {
        return "PhotoPageQuery{" +
                "resourceType=" + resourceType +
                ", deleteStatus=" + deleteStatus +
                ", likesNumber=" + likesNumber +
                ", dlNumber=" + dlNumber +
                '}';
    }
}
