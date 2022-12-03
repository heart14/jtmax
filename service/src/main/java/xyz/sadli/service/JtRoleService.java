package xyz.sadli.service;

import xyz.sadli.entity.JtRole;
import xyz.sadli.query.role.SaveRoleQuery;
import xyz.sadli.vo.JtRoleVO;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/3 21:23.
 * Editored:
 */
public interface JtRoleService {

    /**
     * 查询角色列表
     * @return
     */
    List<JtRoleVO> queryRoleList();

    /**
     * 新增角色
     */
    JtRoleVO saveRole(SaveRoleQuery roleQuery);

    void removeRole(String roleId);
}
