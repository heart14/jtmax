package xyz.sadli.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.entity.Photo;
import xyz.sadli.service.test.PhotoService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysRequest;
import xyz.sadli.vo.SysResponse;

import java.util.List;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:59.
 * Editored:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final PhotoService photoService;

    public TestController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/db", method = RequestMethod.POST)
    public SysResponse db(@RequestBody SysRequest sysRequest) {
        Object biz = sysRequest.getBiz();
        int photoStatus = JSONObject.parseObject((String) biz).getIntValue("photoStatus");
        List<Photo> photos = photoService.dbTest(photoStatus);
        return SysResponseUtils.success(photos);
    }
}
