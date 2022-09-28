package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtRolePermission;

@Mapper
public interface JtRolePermissionMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(JtRolePermission record);

    int insertSelective(JtRolePermission record);

    JtRolePermission selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(JtRolePermission record);

    int updateByPrimaryKey(JtRolePermission record);
}