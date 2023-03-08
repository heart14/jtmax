package xyz.sadli.query.storage;

import xyz.sadli.query.BasePageQuery;

import java.util.Date;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/10 16:11.
 * Editored:
 */
public class StorageBasePageQuery extends BasePageQuery {

    /*
     * 下面的属性，查询时查询Storage表的相关字段
     */
    private String originName;

    private String mediaType;

    private Integer status;

    /*
     * 下面的属性，虽然定义在父类，但是为了给子类继承，查询时查询子类对应表的字段
     */
    private String description;

    private Date createTimeStart;

    private Date createTimeEnd;

    public StorageBasePageQuery() {
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    @Override
    public String toString() {
        return "StorageBasePageQuery{" +
                "originName='" + originName + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                '}';
    }
}
