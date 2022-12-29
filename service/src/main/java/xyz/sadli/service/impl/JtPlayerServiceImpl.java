package xyz.sadli.service.impl;

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
import xyz.sadli.query.sys.LoginQuery;
import xyz.sadli.service.JtPlayerService;
import xyz.sadli.util.BeanUtils;
import xyz.sadli.vo.JtPlayerVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/2 15:01.
 * Editored:
 */
@Service
@CacheConfig(cacheNames = "jtmax:user")
public class JtPlayerServiceImpl implements JtPlayerService {

    private static final Logger log = LoggerFactory.getLogger(xyz.sadli.service.impl.JtPlayerServiceImpl.class);

    private final JtPlayerMapper playerMapper;
    private final JtRoleMapper roleMapper;
    private final JtPermissionMapper permissionMapper;

    public JtPlayerServiceImpl(JtPlayerMapper playerMapper, JtRoleMapper roleMapper, JtPermissionMapper permissionMapper) {
        this.playerMapper = playerMapper;
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public JtPlayer queryPlayerByPhoneNumberAndPassword(LoginQuery loginQuery) {
        log.info("根据手机号密码查询用户");
//        Assert.hasLength(phoneNumber, "参数异常");
//        Assert.hasLength(password, "参数异常");

        JtPlayer jtPlayer = playerMapper.selectPlayerByPhoneNumberAndPassword(loginQuery.getPhoneNumber(), loginQuery.getPassword());
        if (jtPlayer == null) {
            throw new SysException(ErrCodeEnums.LOGIN_EXCEPTION.getCode(), ErrCodeEnums.LOGIN_EXCEPTION.getMsg());
        }
        return jtPlayer;
    }

    @Override
//    @Cacheable(key = "#uid")
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

    @Override
    public List<JtPlayerVO> queryPlayerList() {
        List<JtPlayer> jtPlayers = playerMapper.selectAllPlayer();
        List<JtPlayerVO> voList = jtPlayers.stream().collect(ArrayList::new, (list, player) -> list.add((JtPlayerVO) BeanUtils.beanToVO(player)), ArrayList::addAll);
        return voList;
    }

    @Override
    public void editPlayerStatus(String uid, int status) {
        log.info("更新用户状态: uid={}, status={}", uid, status);
        JtPlayer jtPlayer = playerMapper.selectByPrimaryKey(uid);
        if (jtPlayer == null) {
            throw new SysException(ErrCodeEnums.RESULT_EXCEPTION.getCode(), ErrCodeEnums.RESULT_EXCEPTION.getMsg());
        }
        jtPlayer.setStatus(status);
        jtPlayer.setUpdateTime(new Date());
        int update = playerMapper.updateByPrimaryKeySelective(jtPlayer);
        if (update != 1) {
            throw new SysException(ErrCodeEnums.DB_EXCEPTION.getCode(), ErrCodeEnums.DB_EXCEPTION.getMsg());
        }
    }
}

