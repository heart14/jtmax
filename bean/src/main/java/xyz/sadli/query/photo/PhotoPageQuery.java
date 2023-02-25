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

    public PhotoPageQuery() {
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return "PhotoPageQuery{" +
                "resourceType=" + resourceType +
                '}';
    }
}
