package xyz.sadli.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.common.SysProperties;
import xyz.sadli.entity.JtPlayer;
import xyz.sadli.service.test.JtPlayerService;
import xyz.sadli.thread.pool.SysThreadPoolTaskExecutor;
import xyz.sadli.util.IdWorker;
import xyz.sadli.util.JwtUtils;
import xyz.sadli.util.StringUtils;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysRequest;
import xyz.sadli.vo.SysResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:59.
 * Editored:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    private final SysThreadPoolTaskExecutor threadExecutor;

    public TestController( SysThreadPoolTaskExecutor threadExecutor) {
        this.threadExecutor = threadExecutor;
    }

    @RequestMapping(value = "/db", method = RequestMethod.POST)
    public SysResponse db(@RequestBody SysRequest sysRequest) {
        log.info("test db :{}", sysRequest);
        String biz = sysRequest.getBiz();
        return SysResponseUtils.success(biz);
    }


    @RequestMapping(value = "/p", method = RequestMethod.GET)
    public SysResponse property() {
        String bucketUrl = SysProperties.BUCKET_URL;
        return SysResponseUtils.success(bucketUrl);
    }

    @RequestMapping(value = "/t", method = RequestMethod.GET)
    public SysResponse thread() {
        threadExecutor.execute(() -> log.info("this is a child thread from sys threadPool. and its traceId should be the same to parent"));
        return SysResponseUtils.success();
    }

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public SysResponse snowflake() {
        return SysResponseUtils.success(IdWorker.nextIdStr());
    }

    @RequestMapping(value = "/jwt", method = RequestMethod.GET)
    public SysResponse jwt() {

        String uid = "0x001";

        Map<String, Object> map = new HashMap<>();
        map.put("nickname", "小飞");
        map.put("role", "群主");

        String jwtToken = JwtUtils.createJwtToken(uid, map);
        log.info("create jwtToken :{}", jwtToken);

        Map<String, Object> claims = JwtUtils.parseJwtToken(jwtToken);
        claims.forEach((key, value) -> log.info("verify jwtToken :{} = {}", key, value));

        log.info("verify jwtToken :{}", JwtUtils.verify(jwtToken));

        threadExecutor.execute(() -> {
            try {
                log.info("create a new thread and sleep 35000ms");
                Thread.sleep(35000L);
                log.info("verify jwtToken after ttl :{}", JwtUtils.verify(jwtToken));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return SysResponseUtils.success(jwtToken);
    }

    @Autowired
    private JtPlayerService playerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SysResponse login(@RequestBody SysRequest sysRequest) {
        log.info("test login :{}", sysRequest);

        JtPlayer jtPlayer = playerService.queryPlayerByPhoneNumberAndPassword(JSONObject.parseObject(sysRequest.getBiz()).getString("phoneNumber"), JSONObject.parseObject(sysRequest.getBiz()).getString("password"));

        Map<String, Object> map = new HashMap<>();
        map.put("nickname", jtPlayer.getNickname());
        map.put("introduction", jtPlayer.getIntroduction());

        String jwtToken = JwtUtils.createJwtToken(jtPlayer.getUid(), map);

        Map<String, String> result = new HashMap<>();
        result.put("access_token", jwtToken);
        result.put("refresh_token", StringUtils.UuidLowerCase());
        return SysResponseUtils.success(result);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public SysResponse logout() {
        return SysResponseUtils.success();
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public SysResponse shiroRole() {
        return SysResponseUtils.success("role admin ok");
    }

    @RequiresPermissions("system:player:query")
    @RequestMapping(value = "/perm",method = RequestMethod.GET)
    public SysResponse shiroPerm() {
        return SysResponseUtils.success("perms ok");
    }
}
