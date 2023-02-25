package xyz.sadli.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.service.JtPhotoService;
import xyz.sadli.service.JtStorageService;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/2/26 0:19.
 * Editored:
 */
@Service
public class JtPhotoServiceImpl implements JtPhotoService {

    public static final Logger log = LoggerFactory.getLogger(JtPhotoServiceImpl.class);

    private final JtStorageService storageService;

    public JtPhotoServiceImpl(JtStorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public JtStorage uploadPhoto(MultipartFile file, String creator) {
        //TODO 校验是否是系统支持的图片格式
        //为什么要加这一步，因为storageService里面的upload方法供整个系统使用，支持很多类型的文件上传，所以要前置处理一下
        return storageService.upload(file, creator, Constants.RESOURCE_TYPE_LIBRARY);
    }
}
