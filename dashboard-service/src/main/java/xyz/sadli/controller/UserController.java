package xyz.sadli.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.service.test.JtPlayerService;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtPlayerVO;
import xyz.sadli.vo.SysResponse;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/1 23:37.
 * Editored:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final JtPlayerService jtPlayerService;

    public UserController(JtPlayerService jtPlayerService) {
        this.jtPlayerService = jtPlayerService;
    }

    /**
     * 获取用户信息
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/getUserInfo/{uid}", method = RequestMethod.GET)
    public SysResponse getUserInfo(@PathVariable("uid") String uid) {
        JtPlayerVO player = jtPlayerService.queryPlayerByUid(uid);
        return SysResponseUtils.success(player);
    }
}
