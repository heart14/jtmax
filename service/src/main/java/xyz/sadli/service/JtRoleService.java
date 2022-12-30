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
     * @param roleQuery
     * @return
     */
    JtRoleVO saveRole(SaveRoleQuery roleQuery);

    /**
     * 删除角色
     * @param roleId
     */
    void removeRole(String roleId);

    /**
     * 修改角色
     * @param roleId
     * @param query
     */
    void editRole(String roleId, SaveRoleQuery query);
}
