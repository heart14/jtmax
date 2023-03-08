package xyz.sadli.service;

import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.query.storage.StorageBasePageQuery;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/10 14:04.
 * Editored:
 */
public interface JtStorageService {

    /**
     * 文件上传
     *
     * @param file
     * @param creatorUid
     * @param resourceType
     * @return
     */
    JtStorage upload(MultipartFile file, String creatorUid,int resourceType);

    /**
     * 根据id删除文件(逻辑删除)
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 分页查询文件列表
     * 定义了一个父类StorageBasePageQuery，里面定义了查询参数，每个页面如photo banner页面可以继承这个父类，再定义自己特有的属性
     * 这个接口可以接受这些子类对象作为参数
     *
     * @param query
     * @return
     */
    <T extends StorageBasePageQuery> PageInfo<JtStorage> queryStoragePageList(T query);
}
