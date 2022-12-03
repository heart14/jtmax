package xyz.sadli.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtRoleMapper;
import xyz.sadli.entity.JtRole;
import xyz.sadli.exception.SysException;
import xyz.sadli.query.role.SaveRoleQuery;
import xyz.sadli.service.JtRoleService;
import xyz.sadli.util.BeanUtils;
import xyz.sadli.util.IdWorker;
import xyz.sadli.vo.JtRoleVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/3 21:24.
 * Editored:
 */
@Service
public class JtRoleServiceImpl implements JtRoleService {

    private static final Logger log = LoggerFactory.getLogger(JtRoleServiceImpl.class);

    private final JtRoleMapper jtRoleMapper;

    public JtRoleServiceImpl(JtRoleMapper jtRoleMapper) {
        this.jtRoleMapper = jtRoleMapper;
    }

    @Override
    public List<JtRoleVO> queryRoleList() {
        List<JtRole> jtRoleList = jtRoleMapper.selectRolesByStatus(Constants.STATUS_VALID);
        if (jtRoleList != null) {
            List<JtRoleVO> jtRoleVOList = jtRoleList.stream().collect(ArrayList::new, (list, role) -> list.add((JtRoleVO) BeanUtils.beanToVO(role)), ArrayList::addAll);
            return jtRoleVOList;
        }
        return null;
    }

    @Override
    public JtRoleVO saveRole(SaveRoleQuery roleQuery) {
        //query转化为role
        JtRole role = new JtRole();
        String nextIdStr = IdWorker.nextIdStr();
        role.setRoleId(nextIdStr);
        role.setRoleKey(roleQuery.getRoleKey());
        role.setRoleName(roleQuery.getRoleName());
        role.setRoleDesc(roleQuery.getRoleDesc());
        role.setStatus(Constants.STATUS_VALID);
        role.setCreateTime(new Date());
        int save = jtRoleMapper.insertSelective(role);
        if (save != 1) {
            throw new SysException(ErrCodeEnums.DB_EXCEPTION.getCode(), ErrCodeEnums.DB_EXCEPTION.getMsg());
        }
        JtRoleVO o = (JtRoleVO) BeanUtils.beanToVO(jtRoleMapper.selectByPrimaryKey(nextIdStr));
        return o;
    }

    @Override
    public void removeRole(String roleId) {
        int remove = jtRoleMapper.deleteByPrimaryKey(roleId);
        if (remove != 1) {
            throw new SysException(ErrCodeEnums.DB_EXCEPTION.getCode(), ErrCodeEnums.DB_EXCEPTION.getMsg());
        }
    }
}
