package xyz.sadli.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.service.JtPlayerService;

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

}
