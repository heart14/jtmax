package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sadli.query.role.SaveRoleQuery;
import xyz.sadli.service.JtRoleService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtRoleVO;
import xyz.sadli.vo.SysResponse;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/3 21:21.
 * Editored:
 */
@Api(tags = "角色")
@RestController
@RequestMapping
public class JtRolesController {

    public static final Logger log = LoggerFactory.getLogger(JtRolesController.class);

    private final JtRoleService roleService;

    public JtRolesController(JtRoleService roleService) {
        this.roleService = roleService;
    }


    @ApiOperation("查询角色列表")
    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    public SysResponse listRoles() {
        log.info("查询角色列表");
        List<JtRoleVO> jtRoleVOList = roleService.queryRoleList();
        return SysResponseUtils.success(jtRoleVOList);
    }

    @ApiOperation("新增角色")
    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    public SysResponse saveRole(@RequestBody @Validated SaveRoleQuery role) {
        log.info("新增角色");
        JtRoleVO jtRoleVO = roleService.saveRole(role);
        return SysResponseUtils.success(jtRoleVO);
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "/role/{roleId}", method = RequestMethod.DELETE)
    public SysResponse deleteRole(@PathVariable("roleId") String roleId) {
        log.info("删除角色");
        roleService.removeRole(roleId);
        return SysResponseUtils.success();
    }

    @ApiOperation("更新角色")
    @RequestMapping(value = "/role/{roleId}", method = RequestMethod.PUT)
    public SysResponse modifyRole(@PathVariable("roleId") String roleId,@RequestBody SaveRoleQuery role) {
        log.info("更新角色");
        return SysResponseUtils.success();
    }
}
