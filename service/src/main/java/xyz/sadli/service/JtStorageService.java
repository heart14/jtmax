package xyz.sadli.service;

import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.query.storage.PhotoPageQuery;

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
     * @return
     */
    JtStorage upload(MultipartFile file, String creatorUid);

    /**
     * 根据id删除文件(逻辑删除)
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 分页查询文件列表
     *
     * @param query
     * @return
     */
    PageInfo<JtStorage> queryStoragePageList(PhotoPageQuery query);
}
