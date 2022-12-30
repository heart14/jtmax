package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.sadli.entity.JtPermission;
import xyz.sadli.query.permission.PermissionPageQuery;
import xyz.sadli.query.permission.SavePermissionQuery;

import java.util.List;

@Mapper
public interface JtPermissionMapper {
    int deleteByPrimaryKey(String permId);

    int insert(JtPermission record);

    int insertSelective(JtPermission record);

    JtPermission selectByPrimaryKey(String permId);

    int updateByPrimaryKeySelective(JtPermission record);

    int updateByPrimaryKey(JtPermission record);

    /**
     * 根据主键更新SavePermissionQuery传递的参数
     * @param query
     * @return
     */
    int updateByPrimaryKeyAndQueryParams(@Param("permId") String permId, @Param("query") SavePermissionQuery query);

    /**
     * 更新权限状态
     * @param permId
     * @param status
     * @return
     */
    int updatePermissionStatus(@Param("permId") String permId, @Param("status") int status);

    /**
     * 根据role_id关联查询该角色所有权限
     *
     * @param roleId
     * @return
     */
    List<JtPermission> selectPermByRoleId(String roleId);

    /**
     * 查询所有权限
     *
     * @return
     */
    List<JtPermission> selectAllPermission(PermissionPageQuery query);

    /**
     * 查询所有父权限
     *
     * @return
     */
    List<JtPermission> selectAllParentPermission();

    /**
     * 根据perm_id查询该权限所有子权限
     *
     * @param parentId
     * @return
     */
    List<JtPermission> selectPermsByParentId(String parentId);
}