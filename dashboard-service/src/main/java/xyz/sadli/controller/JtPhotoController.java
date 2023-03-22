package xyz.sadli.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.query.photo.PhotoPageQuery;
import xyz.sadli.service.JtPhotoService;
import xyz.sadli.util.JwtUtils;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtPhotoVO;
import xyz.sadli.vo.SysResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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

    private final JtPhotoService photoService;

    public JtPhotoController(JtPhotoService photoService) {
        this.photoService = photoService;
    }

    @ApiOperation("分页查询画廊图片列表")
    @RequestMapping(value = "/photo/page_list", method = RequestMethod.POST)
    public SysResponse pageList(@RequestBody PhotoPageQuery query) {
        log.info("分页查询画廊图片列表");
        PageInfo<JtPhotoVO> pageInfo = photoService.queryPhotoPageList(query);
        return SysResponseUtils.success(pageInfo);
    }

    @ApiOperation("上传图片")
    @RequestMapping(value = "/photo/upload", method = RequestMethod.POST)
    public SysResponse upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        log.info("上传图片 :{}", multipartFile);
        String jwtToken = request.getHeader(Constants.FIELD_JWT_TOKEN);
        String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
        JtPhotoVO photoVO = photoService.uploadPhoto(multipartFile, uid);
        return SysResponseUtils.success(photoVO);
    }

    @ApiOperation("删除图片")
    @RequestMapping(value = "/photo/{photoId}", method = RequestMethod.DELETE)
    public SysResponse delete(@PathVariable("photoId") String photoId) {
        log.info("删除图片");
        photoService.deletePhoto(photoId);
        return SysResponseUtils.success();
    }

    @ApiOperation("下载图片")
    @RequestMapping(value = "/photo/{photoId}", method = RequestMethod.GET)
    public SysResponse download(@PathVariable("photoId") String photoId, HttpServletRequest request, HttpServletResponse response) {
        log.info("下载图片");
        JtPhotoVO photo = photoService.downloadPhoto(photoId);
        //设置文件路径
        String realPath = photo.getStoragePath();
        File file = new File(realPath);
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + photo.getOriginName());// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                log.error("图片下载失败: {}", e.getMessage(), e);
                return SysResponseUtils.fail(photo);
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return SysResponseUtils.success(photo);
    }
}
