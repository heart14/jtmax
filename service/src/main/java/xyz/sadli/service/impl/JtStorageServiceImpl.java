package xyz.sadli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.common.SysProperties;
import xyz.sadli.dao.JtStorageMapper;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.exception.SysException;
import xyz.sadli.query.storage.StorageBasePageQuery;
import xyz.sadli.service.JtStorageService;
import xyz.sadli.util.IdWorker;
import xyz.sadli.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/10 14:04.
 * Editored:
 */
@Service
public class JtStorageServiceImpl implements JtStorageService {

    public static final Logger log = LoggerFactory.getLogger(JtStorageServiceImpl.class);

    private final JtStorageMapper storageMapper;

    public JtStorageServiceImpl(JtStorageMapper storageMapper) {
        this.storageMapper = storageMapper;
    }

    @Override
    public JtStorage upload(MultipartFile file, String creatorUid,int resourceType) {
        Assert.notNull(file, ErrCodeEnums.PARAMS_EXCEPTION.getMsg());
        typeCheck(file.getContentType());
        Calendar calendar = Calendar.getInstance();
        String root = calendar.get(Calendar.YEAR) + Constants.URL_SEPARATOR + (calendar.get(Calendar.MONTH) + 1) + Constants.URL_SEPARATOR + calendar.get(Calendar.DAY_OF_MONTH);
        String fileType = file.getContentType().split("/")[0];
        String targetDirPath = SysProperties.BUCKET_PATH + fileType + Constants.URL_SEPARATOR + root;
        File targetDir = new File(targetDirPath);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        String uuid = StringUtils.UuidLowerCase();
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase(Locale.ROOT);
        String filePath = targetDirPath + Constants.URL_SEPARATOR + uuid + suffix;
        try {
            // 存储
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new SysException(ErrCodeEnums.FAILED_UPLOAD_EXCEPTION.getCode(), ErrCodeEnums.FAILED_UPLOAD_EXCEPTION.getMsg());
        }
        String url = SysProperties.BUCKET_URL + fileType + Constants.URL_SEPARATOR + root + Constants.URL_SEPARATOR + uuid + suffix;

        // 存储
        JtStorage jtStorage = new JtStorage();
        jtStorage.setId(IdWorker.nextIdStr());
        jtStorage.setOriginName(file.getOriginalFilename());
        jtStorage.setStorageName(uuid + suffix);
        jtStorage.setSize(String.valueOf(file.getSize()));
        jtStorage.setStoragePath(filePath);
        jtStorage.setNetworkUrl(url);
        jtStorage.setMediaType(file.getContentType());
        jtStorage.setResourceType(resourceType);
        jtStorage.setCreator(creatorUid);
        jtStorage.setStatus(Constants.STATUS_VALID);
        jtStorage.setCreateTime(new Date());
        storageMapper.insertSelective(jtStorage);
        return jtStorage;
    }

    @Override
    public void delete(String id) {
        JtStorage storage = storageMapper.selectByPrimaryKey(id);
        Assert.notNull(storage, ErrCodeEnums.NON_FILE_EXCEPTION.getMsg());
        // 更新状态为无效
        storage.setStatus(Constants.STATUS_INVALID);
        storage.setUpdateTime(new Date());
        storageMapper.updateByPrimaryKey(storage);
    }

    @Override
    public <T extends StorageBasePageQuery> PageInfo<JtStorage> queryStoragePageList(T query) {
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<JtStorage> storageList = storageMapper.selectStorageListByQuery(query);
        return new PageInfo<>(storageList);
    }

    /**
     * 检查文件类型是否合法，后期可以将这里检查的类型由枚举类型统一提供
     *
     * @param contentType
     * @return
     */
    private void typeCheck(String contentType) {
        if ("video/mp4".equals(contentType)) {
        } else if (MediaType.IMAGE_PNG_VALUE.equals(contentType)) {
        } else if (MediaType.IMAGE_JPEG_VALUE.equals(contentType)) {
        } else if (MediaType.IMAGE_GIF_VALUE.equals(contentType)) {
        } else {
            throw new SysException(ErrCodeEnums.MEDIA_TYPE_EXCEPTION.getCode(), ErrCodeEnums.MEDIA_TYPE_EXCEPTION.getMsg());
        }
    }
}
