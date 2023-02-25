package xyz.sadli.service;

import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.entity.JtStorage;

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
    JtStorage uploadPhoto(MultipartFile file, String creator);
}
