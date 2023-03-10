package xyz.sadli.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.sadli.common.Constants;
import xyz.sadli.query.banner.BannerPageQuery;
import xyz.sadli.service.JtBannerService;
import xyz.sadli.util.JwtUtils;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtBannerVO;
import xyz.sadli.vo.SysResponse;

import javax.servlet.http.HttpServletRequest;

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

    private final JtBannerService bannerService;

    public JtBannerController(JtBannerService bannerService) {
        this.bannerService = bannerService;
    }

    @ApiOperation("分页查询Banner视频列表")
    @RequestMapping(value = "/banner/page_list", method = RequestMethod.POST)
    public SysResponse listBanners(@RequestBody BannerPageQuery query) {
        log.info("分页查询Banner视频列表");
        PageInfo<JtBannerVO> pageInfo = bannerService.queryBannerPageList(query);
        return SysResponseUtils.success(pageInfo);
    }

    @ApiOperation("上传Banner视频")
    @RequestMapping(value = "/banner/upload", method = RequestMethod.POST)
    public SysResponse uploadBanner(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        log.info("上传Banner视频");
        String jwtToken = request.getHeader(Constants.FIELD_JWT_TOKEN);
        String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
        JtBannerVO bannerVO = bannerService.uploadBanner(multipartFile, uid);
        return SysResponseUtils.success(bannerVO);
    }

    @ApiOperation("删除Banner视频")
    @RequiresPermissions("system:banner:edit")
    @RequestMapping(value = "/banner/{bannerId}", method = RequestMethod.DELETE)
    public SysResponse deleteBanner(@PathVariable("bannerId") String bannerId) {
        log.info("删除Banner视频");
        bannerService.removeBanner(bannerId);
        return SysResponseUtils.success();
    }

    @ApiOperation("设置Banner视频为首页展示")
    @RequiresPermissions("system:banner:edit")
    @RequestMapping(value = "/banner/show/{bannerId}", method = RequestMethod.PATCH)
    public SysResponse showBanner(@PathVariable("bannerId") String bannerId) {
        log.info("设置Banner视频为首页展示");
        bannerService.editBannerShow(bannerId);
        return SysResponseUtils.success();
    }

}
