package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @ApiOperation("查询权限列表")
    @RequestMapping(value = "/permission/list", method = RequestMethod.GET)
    public SysResponse listRoles() {
        log.info("查询权限列表");
        List<JtPermissionVO> voList = permissionService.queryPermissionList();
        return SysResponseUtils.success(voList);
    }
}
