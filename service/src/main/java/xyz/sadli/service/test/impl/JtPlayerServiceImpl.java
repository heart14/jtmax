package xyz.sadli.service.test.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtPermissionMapper;
import xyz.sadli.dao.JtPlayerMapper;
import xyz.sadli.dao.JtRoleMapper;
import xyz.sadli.entity.JtPlayer;
import xyz.sadli.entity.JtRole;
import xyz.sadli.exception.SysException;
import xyz.sadli.service.test.JtPlayerService;
import xyz.sadli.util.BeanUtils;
import xyz.sadli.vo.JtPlayerVO;

import java.util.List;

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
    private final JtRoleMapper roleMapper;
    private final JtPermissionMapper permissionMapper;

    public JtPlayerServiceImpl(JtPlayerMapper playerMapper, JtRoleMapper roleMapper, JtPermissionMapper permissionMapper) {
        this.playerMapper = playerMapper;
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
    }

    @Override
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

    @Override
    @Cacheable(key = "#uid")
    public JtPlayerVO queryPlayerByUid(String uid) {
        log.info("根据用户uid查询用户信息: uid={}", uid);
        Assert.hasLength(uid, "参数异常");

        JtPlayer jtPlayer = playerMapper.selectByPrimaryKey(uid);
        if (jtPlayer == null) {
            throw new SysException(ErrCodeEnums.RESULT_EXCEPTION.getCode(), ErrCodeEnums.RESULT_EXCEPTION.getMsg());
        }
        JtPlayerVO jtPlayerVO = (JtPlayerVO) BeanUtils.beanToVO(jtPlayer);
        List<JtRole> jtRoles = roleMapper.selectRolesByUid(jtPlayer.getUid());
        if (jtRoles != null) {
            //String[] roleArray = jtRoles.stream().map(role -> role.getRoleKey()).toArray(String[]::new);
            //上下两种写法效果一样
            String[] roleArray = jtRoles.stream().map(JtRole::getRoleKey).toArray(String[]::new);
            jtPlayerVO.setRoles(roleArray);
        }
        return jtPlayerVO;
    }
}
