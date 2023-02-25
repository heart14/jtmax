package xyz.sadli.query.photo;

import xyz.sadli.query.storage.StorageBasePageQuery;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/2/26 1:50.
 * Editored:
 */
public class BannerPageQuery extends StorageBasePageQuery {

    // banner的resourceType值固定为0
    private Integer resourceType = 0;

    public BannerPageQuery() {
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return "BannerPageQuery{" +
                "resourceType=" + resourceType +
                '}';
    }
}
