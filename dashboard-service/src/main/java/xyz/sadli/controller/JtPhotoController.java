package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.common.SysProperties;
import xyz.sadli.exception.SysException;
import xyz.sadli.util.IdWorker;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysResponse;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/9 17:53.
 * Editored:
 */
@Api(tags = "街头画廊")
@RestController
@RequestMapping
public class JtPhotoController {

    public static final Logger log = LoggerFactory.getLogger(JtPhotoController.class);

    @ApiOperation("上传图片")
    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public SysResponse upload(@RequestParam("file") MultipartFile multipartFile) {
        log.info("上传图片 :{}", multipartFile);

        Calendar calendar = Calendar.getInstance();
        String root = calendar.get(Calendar.YEAR) + Constants.URL_SEPARATOR
                + (calendar.get(Calendar.MONTH) + 1) + Constants.URL_SEPARATOR
                + calendar.get(Calendar.DAY_OF_MONTH);


        String targetDirPath = SysProperties.BUCKET_PATH + Constants.URL_SEPARATOR + root;
        File targetDir = new File(targetDirPath);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        if (MediaType.IMAGE_JPEG_VALUE.equalsIgnoreCase(multipartFile.getContentType()) || MediaType.IMAGE_PNG_VALUE.equalsIgnoreCase(multipartFile.getContentType()) || MediaType.IMAGE_GIF_VALUE.equalsIgnoreCase(multipartFile.getContentType())) {
            String filePath = targetDirPath + Constants.URL_SEPARATOR + multipartFile.getOriginalFilename();
            try {
                multipartFile.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileUrl = SysProperties.BUCKET_URL + Constants.URL_SEPARATOR + root + Constants.URL_SEPARATOR + multipartFile.getOriginalFilename();

            Map<String, String> map = new HashMap<>();
            map.put("fileId", IdWorker.nextIdStr());
            map.put("fileName", multipartFile.getOriginalFilename());
            map.put("filePath", filePath);
            map.put("fileUrl", fileUrl);

            return SysResponseUtils.success(map);
        } else {
            throw new SysException(ErrCodeEnums.UNSUPPORT_MEDIA_TYPE.getCode(), ErrCodeEnums.UNSUPPORT_MEDIA_TYPE.getMsg());
        }
    }
}
