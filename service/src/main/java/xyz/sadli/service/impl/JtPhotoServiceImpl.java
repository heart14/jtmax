package xyz.sadli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtPhotoMapper;
import xyz.sadli.entity.JtPhoto;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.query.photo.PhotoPageQuery;
import xyz.sadli.service.JtPhotoService;
import xyz.sadli.service.JtStorageService;
import xyz.sadli.util.IdWorker;
import xyz.sadli.vo.JtPhotoVO;

import java.util.Date;
import java.util.List;

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

    private final JtPhotoMapper photoMapper;

    public JtPhotoServiceImpl(JtStorageService storageService, JtPhotoMapper photoMapper) {
        this.storageService = storageService;
        this.photoMapper = photoMapper;
    }

    @Override
    public JtPhotoVO uploadPhoto(MultipartFile file, String creator) {
        // TODO 校验是否是系统支持的图片格式
        // 为什么要加这一步，因为storageService里面的upload方法供整个系统使用，支持很多类型的文件上传，所以要前置处理一下
        JtStorage storage = storageService.upload(file, creator, Constants.RESOURCE_TYPE_LIBRARY);

        // 保存photo表
        JtPhoto photo = new JtPhoto();
        String nextIdStr = IdWorker.nextIdStr();
        photo.setPhotoId(nextIdStr);
        photo.setStorageId(storage.getId());
        photo.setOriginName(file.getOriginalFilename());
        photo.setDescription("");
        photo.setDeleteStatus(Constants.STATUS_VALID);
        photo.setLikesNumber(0);
        photo.setDlNumber(0);
        photo.setCreateTime(storage.getCreateTime());
        photoMapper.insert(photo);
        return new JtPhotoVO(photo, storage);
    }

    @Override
    public PageInfo<JtPhotoVO> queryPhotoPageList(PhotoPageQuery query) {
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<JtPhotoVO> voList = photoMapper.selectPhotoVOListByQuery(query);
        return new PageInfo<>(voList);
    }

    @Override
    public void deletePhoto(String photoId) {
        JtPhoto photo = photoMapper.selectByPrimaryKey(photoId);
        Assert.notNull(photo, ErrCodeEnums.NON_FILE_EXCEPTION.getMsg());
        // 更新状态为已删除（逻辑删除）
        photo.setDeleteStatus(Constants.STATUS_INVALID);
        photo.setUpdateTime(new Date());
        photoMapper.updateByPrimaryKey(photo);
    }

    @Override
    public JtPhotoVO downloadPhoto(String photoId) {
        JtPhotoVO photo = photoMapper.selectPhotoVOById(photoId);
        Assert.notNull(photo, ErrCodeEnums.NON_FILE_EXCEPTION.getMsg());
        return photo;
    }
}
