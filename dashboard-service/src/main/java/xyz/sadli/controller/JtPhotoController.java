package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.service.JtStorageService;
import xyz.sadli.util.JwtUtils;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysResponse;

import javax.servlet.http.HttpServletRequest;

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

    private final JtStorageService storageService;

    public JtPhotoController(JtStorageService storageService) {
        this.storageService = storageService;
    }

    @ApiOperation("上传图片")
    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public SysResponse upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        log.info("上传图片 :{}", multipartFile);
        String jwtToken = request.getHeader(Constants.FIELD_JWT_TOKEN);
        String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
        JtStorage upload = storageService.upload(multipartFile, uid);
        return SysResponseUtils.success(upload);
    }
}
