package xyz.sadli.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.sadli.domain.JtActivityPlayerInfo;
import xyz.sadli.entity.JtActivity;
import xyz.sadli.query.activity.ActivityPageQuery;
import xyz.sadli.query.activity.ActivityPlayerPageQuery;
import xyz.sadli.query.activity.SaveActivityQuery;
import xyz.sadli.service.JtActivityService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysResponse;

import java.util.List;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/6 11:26.
 * Editored:
 */
@Api(tags = "活动信息")
@RestController
@RequestMapping
public class JtActivityController {

    public static final Logger log = LoggerFactory.getLogger(JtActivityController.class);

    private final JtActivityService activityService;

    public JtActivityController(JtActivityService activityService) {
        this.activityService = activityService;
    }

    @ApiOperation("分页查询活动列表")
    @RequestMapping(value = "/activity/page_list", method = RequestMethod.POST)
    public SysResponse pageList(@RequestBody ActivityPageQuery query) {
        log.info("分页查询活动列表: {}", query);
        PageInfo<JtActivity> pageInfo = activityService.queryActivityPageList(query);
        return SysResponseUtils.success(pageInfo);
    }

    @ApiOperation("查询活动列表")
    @RequestMapping(value = "/activity/list", method = RequestMethod.GET)
    public SysResponse activityList() {
        log.info("分页查询活动列表");
        List<JtActivity> list = activityService.queryAllActivity();
        return SysResponseUtils.success(list);
    }

    @ApiOperation("新增活动")
    @RequestMapping(value = "/activity/save", method = RequestMethod.POST)
    public SysResponse saveActivity(@RequestBody SaveActivityQuery query) {
        log.info("新增活动: {}", query);
        JtActivity jtActivity = activityService.saveActivity(query);
        return SysResponseUtils.success(jtActivity);
    }

    @ApiOperation("更新活动")
    @RequestMapping(value = "/activity/{activityId}", method = RequestMethod.PUT)
    public SysResponse editActivity(@PathVariable("activityId") String activityId, @RequestBody SaveActivityQuery query) {
        log.info("更新活动: {}", query);
        activityService.editActivity(activityId, query);
        return SysResponseUtils.success();
    }

    @ApiOperation("删除活动")
    @RequestMapping(value = "/activity/{activityId}", method = RequestMethod.DELETE)
    public SysResponse removePermission(@PathVariable("activityId") String activityId) {
        log.info("删除活动");
        activityService.removeActivity(activityId);
        return SysResponseUtils.success();
    }

    @ApiOperation("发布活动")
    @RequestMapping(value = "/activity/publish/{activityId}", method = RequestMethod.PATCH)
    public SysResponse publishActivity(@PathVariable("activityId") String activityId) {
        log.info("发布活动: {}", activityId);
        activityService.publishActivity(activityId);
        return SysResponseUtils.success();
    }

    @ApiOperation("分页查询活动报名信息列表")
    @RequestMapping(value = "/activity_player/page_list", method = RequestMethod.POST)
    public SysResponse activityPlayerPageList(@RequestBody ActivityPlayerPageQuery query) {
        log.info("分页查询活动报名信息列表: {}", query);
        PageInfo<JtActivityPlayerInfo> pageInfo = activityService.queryActivityPlayerPageList(query);
        return SysResponseUtils.success(pageInfo);
    }
}
