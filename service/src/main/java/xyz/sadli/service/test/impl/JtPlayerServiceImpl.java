package xyz.sadli.service.test.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtPlayerMapper;
import xyz.sadli.entity.JtPlayer;
import xyz.sadli.exception.SysException;
import xyz.sadli.service.test.JtPlayerService;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/30 16:03.
 * Editored:
 */
@Service
@CacheConfig(cacheNames = "jtmax:user")
public class JtPlayerServiceImpl implements JtPlayerService {

    private static final Logger log = LoggerFactory.getLogger(JtPlayerServiceImpl.class);

    private final JtPlayerMapper playerMapper;

    public JtPlayerServiceImpl(JtPlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @Override
    @Cacheable(key = "#phoneNumber")
    public JtPlayer queryPlayerByPhoneNumberAndPassword(String phoneNumber, String password) {
        log.info("根据手机号密码查询用户");
        Assert.hasLength(phoneNumber, "参数异常");
        Assert.hasLength(password, "参数异常");

        JtPlayer jtPlayer = playerMapper.selectPlayerByPhoneNumberAndPassword(phoneNumber, password);
        if (jtPlayer == null) {
            throw new SysException(ErrCodeEnums.LOGIN_EXCEPTION.getCode(), ErrCodeEnums.LOGIN_EXCEPTION.getMsg());
        }
        return jtPlayer;
    }
}
