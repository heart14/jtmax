package xyz.sadli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.dao.JtPermissionMapper;
import xyz.sadli.entity.JtPermission;
import xyz.sadli.query.permission.PermissionPageQuery;
import xyz.sadli.service.JtPermissionService;
import xyz.sadli.util.BeanUtils;
import xyz.sadli.util.StringUtils;
import xyz.sadli.vo.JtPermissionVO;
import xyz.sadli.vo.JtRoleVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            permissions.forEach(e->{
                JtPermissionVO vo2 = new JtPermissionVO();
                vo2.setPermId(e.getPermId());
                vo2.setPath(e.getPermRoute());
                vo2.setName(StringUtils.parseRoutePathToName(e.getPermRoute()));
                vo2.setAlwaysShow(true);
                Map<String, String> meta2 = new HashMap<>();
                meta2.put("title", e.getPermName());
                vo2.setMeta(meta2);
                vo2.setHidden(true);
                vo2.setRedirect("");

                child.add(vo2);
            });
            vo.setChildren(child);
            vo.setRedirect(child.get(0).getPath());

            voList.add(vo);
        });
        return voList;
    }

    @Override
    public PageInfo<JtPermission> queryPermissionPageList(PermissionPageQuery query) {
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<JtPermission> allPermission = permissionMapper.selectAllPermission();
        return new PageInfo<>(allPermission);
    }
}
