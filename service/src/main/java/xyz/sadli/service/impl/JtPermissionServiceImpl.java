package xyz.sadli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtPermissionMapper;
import xyz.sadli.entity.JtPermission;
import xyz.sadli.exception.SysException;
import xyz.sadli.query.permission.PermissionPageQuery;
import xyz.sadli.query.permission.SavePermissionQuery;
import xyz.sadli.service.JtPermissionService;
import xyz.sadli.util.BeanUtils;
import xyz.sadli.util.IdWorker;
import xyz.sadli.util.StringUtils;
import xyz.sadli.vo.JtPermissionVO;
import xyz.sadli.vo.JtRoleVO;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/4 21:12.
 * Editored:
 */
@Service
public class JtPermissionServiceImpl implements JtPermissionService {

    private static final Logger log = LoggerFactory.getLogger(JtPermissionServiceImpl.class);

    private final JtPermissionMapper permissionMapper;

    public JtPermissionServiceImpl(JtPermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<JtPermissionVO> queryPermissionList() {
        List<JtPermission> parentPermission = permissionMapper.selectAllParentPermission();

        List<JtPermissionVO> voList = new ArrayList<>();
        parentPermission.forEach(p->{

            JtPermissionVO vo = new JtPermissionVO();
            vo.setPermId(p.getPermId());
            vo.setPath(p.getPermRoute());
            vo.setName(StringUtils.parseRoutePathToName(p.getPermRoute()));
            vo.setAlwaysShow(true);
            Map<String, String> meta = new HashMap<>();
            meta.put("title", p.getPermName());
            vo.setMeta(meta);
            vo.setHidden(false);

            List<JtPermission> permissions = permissionMapper.selectPermsByParentId(p.getPermId());
            List<JtPermissionVO> child = new ArrayList<>();
            List<JtPermissionVO> emptyChild = new ArrayList<>();//只有二级菜单，给子权限的子权限字段置空
            permissions.forEach(e->{
                JtPermissionVO vo2 = new JtPermissionVO();
                vo2.setPermId(e.getPermId());
                vo2.setPath(e.getPermRoute());
                vo2.setRedirect(e.getPermRoute());
                vo2.setName(StringUtils.parseRoutePathToName(e.getPermRoute()));
                vo2.setAlwaysShow(true);
                Map<String, String> meta2 = new HashMap<>();
                meta2.put("title", e.getPermName());
                vo2.setMeta(meta2);
                vo2.setHidden(true);
                vo2.setChildren(emptyChild);

                child.add(vo2);
            });
            vo.setChildren(child);
            vo.setRedirect(child.size() > 0 ? child.get(0).getPath() : p.getPermRoute());

            voList.add(vo);
        });
        return voList;
    }

    @Override
    public PageInfo<JtPermission> queryPermissionPageList(PermissionPageQuery query) {
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<JtPermission> allPermission = permissionMapper.selectAllPermission(query);
        return new PageInfo<>(allPermission);
    }

    @Override
    public JtPermission savePermission(SavePermissionQuery query) {
        JtPermission permission = new JtPermission();
        String idStr = IdWorker.nextIdStr();
        permission.setPermId(idStr);
        permission.setPermName(query.getPermName());
        permission.setPermDesc(query.getPermDesc());
        permission.setPermType(query.getPermType());
        permission.setPermRoute(query.getPermRoute());
        permission.setPermIndex(query.getPermIndex());
        permission.setPermKey(query.getPermKey());
        permission.setParentId(query.getParentId());
        permission.setStatus(Constants.STATUS_VALID);
        permission.setCreateTime(new Date());
        int save = permissionMapper.insertSelective(permission);
        if (save != 1) {
            throw new SysException(ErrCodeEnums.DB_EXCEPTION.getCode(), ErrCodeEnums.DB_EXCEPTION.getMsg());
        }
        return permission;
    }

    @Override
    public void editPermission(String permId, SavePermissionQuery query) {
        JtPermission permission = permissionMapper.selectByPrimaryKey(permId);
        if (permission == null) {
            throw new SysException(ErrCodeEnums.RESULT_EXCEPTION.getCode(),ErrCodeEnums.RESULT_EXCEPTION.getMsg());
        }
        int update = permissionMapper.updateByPrimaryKeyAndQueryParams(permId, query);
        if (update != 1) {
            throw new SysException(ErrCodeEnums.DB_EXCEPTION.getCode(), ErrCodeEnums.DB_EXCEPTION.getMsg());
        }
    }

    @Override
    public void removePermission(String permId) {
        // 物理删除
        int i = permissionMapper.deleteByPrimaryKey(permId);
        if (i != 1) {
            throw new SysException(ErrCodeEnums.DB_EXCEPTION.getCode(), ErrCodeEnums.DB_EXCEPTION.getMsg());
        }
    }
}
