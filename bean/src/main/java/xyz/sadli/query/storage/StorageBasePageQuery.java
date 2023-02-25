package xyz.sadli.query.storage;

import xyz.sadli.query.BasePageQuery;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/10 16:11.
 * Editored:
 */
public class StorageBasePageQuery extends BasePageQuery {

    private Integer status;

    private String originName;

    private String description;

    public StorageBasePageQuery() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
                "status=" + status +
                ", originName='" + originName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
