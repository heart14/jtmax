package xyz.sadli.service;

import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.query.photo.PhotoPageQuery;
import xyz.sadli.vo.JtPhotoVO;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/2/26 0:19.
 * Editored:
 */
public interface JtPhotoService {

    /**
     * 图片上传
     *
     * @param file
     * @param creator
     * @return
     */
    JtPhotoVO uploadPhoto(MultipartFile file, String creator);

    /**
     * 分页查询图片信息
     *
     * @param query
     * @return
     */
    PageInfo<JtPhotoVO> queryPhotoPageList(PhotoPageQuery query);

    /**
     * 删除图片
     *
     * @param photoId
     */
    void deletePhoto(String photoId);

    /**
     * 下载图片
     *
     * @param photoId
     * @return
     */
    JtPhotoVO downloadPhoto(String photoId);
}
