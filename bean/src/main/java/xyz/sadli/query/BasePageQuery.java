package xyz.sadli.query;

/**
 * About: 分页查询Query类的基类，定义分页属性，所有分页查询都需要这两个属性，所以直接继承这个类就行了
 * Other:
 * Created: lwf14 on 2023/2/26 0:30.
 * Editored:
 */
public class BasePageQuery {

    private int page;

    private int limit;

    public BasePageQuery() {
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

    @Override
    public String toString() {
        return "PageQuery{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
