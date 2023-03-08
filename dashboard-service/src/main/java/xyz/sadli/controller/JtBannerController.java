package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.common.Constants;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtPlayerVO;
import xyz.sadli.vo.SysResponse;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/3/8 20:22.
 * Editored:
 */
@Api(tags = "Banner视频")
@RestController
@RequestMapping
public class JtBannerController {

    public static final Logger log = LoggerFactory.getLogger(JtBannerController.class);

    @ApiOperation("分页查询Banner视频列表")
    @RequestMapping(value = "/banner/page_list", method = RequestMethod.GET)
    public SysResponse listBanners() {
        log.info("分页查询Banner视频列表");
        return SysResponseUtils.success();
    }

    @ApiOperation("上传Banner视频")
    @RequestMapping(value = "/banner/upload", method = RequestMethod.POST)
    public SysResponse uploadBanner() {
        log.info("上传Banner视频");
        /*
         * 如果只有一个有效视频，那它默认首页展示
         */
        return SysResponseUtils.success();
    }

    @ApiOperation("删除Banner视频")
    @RequiresPermissions("system:banner:edit")
    @RequestMapping(value = "/banner/delete", method = RequestMethod.POST)
    public SysResponse deleteBanner() {
        log.info("删除Banner视频");
        return SysResponseUtils.success();
    }

    @ApiOperation("设置Banner视频为首页展示")
    @RequiresPermissions("system:banner:edit")
    @RequestMapping(value = "/banner/show/{bannerId}", method = RequestMethod.PATCH)
    public SysResponse showBanner(@PathVariable("bannerId") String bannerId) {
        log.info("设置Banner视频为首页展示");
        /*
         * 将一个视频设置为首页展示时，需要同时把其它的更新为不展示
         */
        return SysResponseUtils.success();
    }

}
