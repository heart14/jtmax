package xyz.sadli.query.storage;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/10 16:11.
 * Editored:
 */
public class PhotoPageQuery {

    private int page;

    private int limit;

    private Integer status;

    // 图库的resourceType值固定为1
    private Integer resourceType = 1;

    private String originName;

    private String description;

    public PhotoPageQuery() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
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

    @Override
    public String toString() {
        return "PhotoPageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", status=" + status +
                ", resourceType=" + resourceType +
                ", originName='" + originName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
