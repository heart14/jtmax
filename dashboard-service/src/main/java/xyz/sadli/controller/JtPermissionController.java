package xyz.sadli.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.sadli.entity.JtPermission;
import xyz.sadli.query.permission.PermissionPageQuery;
import xyz.sadli.query.permission.SavePermissionQuery;
import xyz.sadli.service.JtPermissionService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtPermissionVO;
import xyz.sadli.vo.SysResponse;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/4 21:07.
 * Editored:
 */
@Api(tags = "权限")
@RestController
@RequestMapping
public class JtPermissionController {

    public static final Logger log = LoggerFactory.getLogger(JtPermissionController.class);

    private final JtPermissionService permissionService;

    public JtPermissionController(JtPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @ApiOperation("查询路由权限列表")
    @RequestMapping(value = "/permission/list", method = RequestMethod.GET)
    public SysResponse listRoles() {
        log.info("查询路由权限列表");
        List<JtPermissionVO> voList = permissionService.queryPermissionList();
        return SysResponseUtils.success(voList);
    }

    @ApiOperation("分页查询权限列表")
    @RequestMapping(value = "/permission/page_list", method = RequestMethod.POST)
    public SysResponse pageList(@RequestBody PermissionPageQuery query) {
        log.info("分页查询权限列表: {}", query);
        PageInfo<JtPermission> pageInfo = permissionService.queryPermissionPageList(query);
        return SysResponseUtils.success(pageInfo);
    }

    @ApiOperation("新增权限")
    @RequestMapping(value = "/permission/save", method = RequestMethod.POST)
    public SysResponse savePermission(@RequestBody SavePermissionQuery query) {
        log.info("新增权限: {}", query);
        JtPermission jtPermission = permissionService.savePermission(query);
        return SysResponseUtils.success(jtPermission);
    }

    @ApiOperation("更新权限")
    @RequestMapping(value = "/permission/{permId}", method = RequestMethod.PUT)
    public SysResponse editPermission(@PathVariable("permId") String permId, @RequestBody SavePermissionQuery query) {
        log.info("更新权限: {}", query);
        permissionService.editPermission(permId, query);
        return SysResponseUtils.success();
    }

    @ApiOperation("删除权限")
    @RequestMapping(value = "/permission/{permId}", method = RequestMethod.DELETE)
    public SysResponse removePermission(@PathVariable("permId") String permId) {
        log.info("删除权限");
        permissionService.removePermission(permId);
        return SysResponseUtils.success();
    }
}
