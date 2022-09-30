package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtPermission;

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
     * 根据role_id关联查询该角色所有权限
     * @param roleId
     * @return
     */
    List<JtPermission> selectPermByRoleId(String roleId);
}