package xyz.sadli.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.entity.JtActivity;
import xyz.sadli.query.activity.ActivityPageQuery;
import xyz.sadli.service.JtActivityService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysResponse;

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

}
