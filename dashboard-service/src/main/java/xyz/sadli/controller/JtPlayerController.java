package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.service.JtPlayerService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtPlayerVO;
import xyz.sadli.vo.JtRoleVO;
import xyz.sadli.vo.SysResponse;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/1 23:37.
 * Editored:
 */
@Api(tags = "用户")
@RestController
@RequestMapping
public class JtPlayerController {

    public static final Logger log = LoggerFactory.getLogger(JtPlayerController.class);

    private final JtPlayerService jtPlayerService;

    public JtPlayerController(JtPlayerService jtPlayerService) {
        this.jtPlayerService = jtPlayerService;
    }

    @ApiOperation("查询用户列表")
    @RequestMapping(value = "/player/list", method = RequestMethod.GET)
    public SysResponse listRoles() {
        log.info("查询用户列表");
        List<JtPlayerVO> voList = jtPlayerService.queryPlayerList();
        return SysResponseUtils.success(voList);
    }
}
