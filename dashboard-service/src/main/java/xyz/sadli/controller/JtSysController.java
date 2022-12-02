package xyz.sadli.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sadli.common.Constants;
import xyz.sadli.entity.JtPlayer;
import xyz.sadli.query.sys.LoginQuery;
import xyz.sadli.service.JtPlayerService;
import xyz.sadli.util.JwtUtils;
import xyz.sadli.util.StringUtils;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.JtPlayerVO;
import xyz.sadli.vo.SysResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/2 15:10.
 * Editored:
 */
@Api(tags = "系统")
@RestController
@RequestMapping("sys")
public class JtSysController {

    public static final Logger log = LoggerFactory.getLogger(JtSysController.class);

    private final StringRedisTemplate redisTemplate;
    private final JtPlayerService playerService;

    public JtSysController(StringRedisTemplate redisTemplate, JtPlayerService playerService) {
        this.redisTemplate = redisTemplate;
        this.playerService = playerService;
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SysResponse login(@RequestBody @Validated LoginQuery loginQuery) {

        JtPlayer jtPlayer = playerService.queryPlayerByPhoneNumberAndPassword(loginQuery);

        Map<String, Object> map = new HashMap<>();
        map.put("nickname", jtPlayer.getNickname());
        map.put("introduction", jtPlayer.getIntroduction());

        String jwtToken = JwtUtils.createJwtToken(jtPlayer.getUid(), map);

        Map<String, String> result = new HashMap<>();
        result.put("access_token", jwtToken);
        String refreshToken = StringUtils.UuidLowerCase();
        result.put("refresh_token", refreshToken);
        redisTemplate.opsForValue().set(Constants.ACCESS_TOKEN_PREFIX + Constants.REDIS_KEY_SEPARATOR + jtPlayer.getUid(), jwtToken, Constants.REDIS_ACCESS_TOKEN_TTL, TimeUnit.MILLISECONDS);
        redisTemplate.opsForValue().set(Constants.REFRESH_TOKEN_PREFIX + Constants.REDIS_KEY_SEPARATOR + jtPlayer.getUid(), refreshToken, Constants.REDIS_REFRESH_TOKEN_TTL, TimeUnit.MILLISECONDS);

        return SysResponseUtils.success(result);
    }

    @ApiOperation("获取图片验证码")
    @RequestMapping(value = "/verify_code/image", method = RequestMethod.GET)
    public SysResponse imageVerifyCode() {

        return SysResponseUtils.success();
    }

    @ApiOperation("获取短信验证码")
    @RequestMapping(value = "/verify_code/sms", method = RequestMethod.GET)
    public SysResponse smsVerifyCode() {

        return SysResponseUtils.success();
    }

    @ApiOperation("用户登出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public SysResponse logout(HttpServletRequest request) {
        String jwtToken = request.getHeader(Constants.FIELD_JWT_TOKEN);
        if (JwtUtils.verify(jwtToken)) {
            String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
            log.info("logout :uid = {}", uid);
            //使token失效
            redisTemplate.delete(Constants.ACCESS_TOKEN_PREFIX + Constants.REDIS_KEY_SEPARATOR + uid);
            redisTemplate.delete(Constants.REFRESH_TOKEN_PREFIX + Constants.REDIS_KEY_SEPARATOR + uid);
        }
        return SysResponseUtils.success();
    }

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/player_info/{uid}", method = RequestMethod.GET)
    public SysResponse playerInfo(@PathVariable("uid") String uid) {
        JtPlayerVO player = playerService.queryPlayerByUid(uid);
        return SysResponseUtils.success(player);
    }

    @ApiOperation("刷新Token")
    @RequestMapping(value = "/access_token/{refresh_token}", method = RequestMethod.GET)
    public SysResponse refreshToken(@PathVariable("refresh_token")String refreshToken) {
        log.info("refresh_token :{}", refreshToken);
        //TODO
        return SysResponseUtils.success();
    }
}
