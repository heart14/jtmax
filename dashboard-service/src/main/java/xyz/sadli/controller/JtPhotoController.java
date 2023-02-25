package xyz.sadli.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.query.storage.PhotoPageQuery;
import xyz.sadli.service.JtPhotoService;
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
@Api(tags = "画廊")
@RestController
@RequestMapping
public class JtPhotoController {

    public static final Logger log = LoggerFactory.getLogger(JtPhotoController.class);

    private final JtStorageService storageService;

    private final JtPhotoService photoService;

    public JtPhotoController(JtStorageService storageService, JtPhotoService photoService) {
        this.storageService = storageService;
        this.photoService = photoService;
    }

    @ApiOperation("分页查询画廊图片列表")
    @RequestMapping(value = "/photo/page_list", method = RequestMethod.POST)
    public SysResponse pageList(@RequestBody PhotoPageQuery query) {
        log.info("分页查询画廊图片列表");
        PageInfo<JtStorage> pageInfo = storageService.queryStoragePageList(query);
        return SysResponseUtils.success(pageInfo);
    }

    @ApiOperation("上传图片")
    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public SysResponse upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        log.info("上传图片 :{}", multipartFile);
        String jwtToken = request.getHeader(Constants.FIELD_JWT_TOKEN);
        String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
        JtStorage upload = photoService.uploadPhoto(multipartFile, uid);
        return SysResponseUtils.success(upload);
    }

    @ApiOperation("删除图片")
    @RequestMapping(value = "/photo/{id}", method = RequestMethod.DELETE)
    public SysResponse delete(@PathVariable("id") String id) {
        log.info("删除图片");
        storageService.delete(id);
        return SysResponseUtils.success();
    }
}
