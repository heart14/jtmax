package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.service.JtPlayerService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtPlayerVO;
import xyz.sadli.vo.SysResponse;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/1 23:37.
 * Editored:
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class JtPlayerController {

    public static final Logger log = LoggerFactory.getLogger(JtPlayerController.class);

    private final JtPlayerService jtPlayerService;

    public JtPlayerController(JtPlayerService jtPlayerService) {
        this.jtPlayerService = jtPlayerService;
    }

    /**
     * 获取用户信息
     *
     * @param uid
     * @return
     */
    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/getUserInfo/{uid}", method = RequestMethod.GET)
    public SysResponse getUserInfo(@PathVariable("uid") String uid) {
        JtPlayerVO player = jtPlayerService.queryPlayerByUid(uid);
        return SysResponseUtils.success(player);
    }
}
