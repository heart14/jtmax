package xyz.sadli.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sadli.common.Constants;
import xyz.sadli.common.SysProperties;
import xyz.sadli.entity.JtLog;
import xyz.sadli.entity.JtPlayer;
import xyz.sadli.query.sys.LoginQuery;
import xyz.sadli.service.JtLogService;
import xyz.sadli.service.JtPlayerService;
import xyz.sadli.thread.pool.SysThreadPoolTaskExecutor;
import xyz.sadli.util.IdWorker;
import xyz.sadli.util.JwtUtils;
import xyz.sadli.util.StringUtils;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysRequest;
import xyz.sadli.vo.SysResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    private final JtLogService logService;

    public TestController(SysThreadPoolTaskExecutor threadExecutor, JtLogService logService) {
        this.threadExecutor = threadExecutor;
        this.logService = logService;
    }

    @RequestMapping(value = "/db", method = RequestMethod.POST)
    public SysResponse db(@RequestBody SysRequest sysRequest) {
        log.info("test db :{}", sysRequest);
        String uid = JSONObject.parseObject(sysRequest.getBiz()).getString("uid");
        List<JtLog> jtLogs = logService.queryJtLogListByUid(uid);
        return SysResponseUtils.success(jtLogs);
    }

    @RequestMapping(value = "/cache", method = RequestMethod.POST)
    public SysResponse cache(@RequestBody SysRequest sysRequest) {
        log.info("test cache :{}", sysRequest);
        String logId = JSONObject.parseObject(sysRequest.getBiz()).getString("logId");
        JtLog jtLog = logService.queryJtLogById(logId);
        return SysResponseUtils.success(jtLog);
    }


    @RequestMapping(value = "/p", method = RequestMethod.GET)
    public SysResponse property() {
        log.info("test property");
        String bucketUrl = SysProperties.BUCKET_URL;
        return SysResponseUtils.success(bucketUrl);
    }

    @RequestMapping(value = "/t", method = RequestMethod.GET)
    public SysResponse thread() {
        log.info("test thread");
        threadExecutor.execute(() -> log.info("this is a child thread from sys threadPool. and its traceId should be the same to parent"));
        return SysResponseUtils.success();
    }

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public SysResponse snowflake() {
        log.info("test snowflake");
        return SysResponseUtils.success(IdWorker.nextIdStr());
    }

    @RequestMapping(value = "/jwt", method = RequestMethod.GET)
    public SysResponse jwt() {
        log.info("test jwt");

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

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public SysResponse login(@RequestBody SysRequest sysRequest) {
        log.info("test login :{}", sysRequest);

        LoginQuery loginQuery = new LoginQuery();
        loginQuery.setPhoneNumber(JSONObject.parseObject(sysRequest.getBiz()).getString("phoneNumber"));
        loginQuery.setPassword( JSONObject.parseObject(sysRequest.getBiz()).getString("password"));

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

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public SysResponse logout(HttpServletRequest request) {
        String jwtToken = request.getHeader(Constants.FIELD_JWT_TOKEN);
        if (JwtUtils.verify(jwtToken)) {
            String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
            log.info("test logout :uid = {}", uid);
            //使token失效
            redisTemplate.delete(Constants.ACCESS_TOKEN_PREFIX + Constants.REDIS_KEY_SEPARATOR + uid);
            redisTemplate.delete(Constants.REFRESH_TOKEN_PREFIX + Constants.REDIS_KEY_SEPARATOR + uid);
        }
        return SysResponseUtils.success();
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public SysResponse shiroRole() {
        log.info("test shiro requires roles");
        return SysResponseUtils.success("role admin ok");
    }

    @RequiresPermissions("system:player:query")
    @RequestMapping(value = "/perm", method = RequestMethod.GET)
    public SysResponse shiroPerm() {
        log.info("test shiro requires permissions");
        return SysResponseUtils.success("perms ok");
    }

    @RequestMapping(value = "/w", method = RequestMethod.GET)
    public SysResponse webhooks() {
        log.info("test github webhooks");
        return SysResponseUtils.success("111");
    }
}
