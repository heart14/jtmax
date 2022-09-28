package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtRole;

@Mapper
public interface JtRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(JtRole record);

    int insertSelective(JtRole record);

    JtRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(JtRole record);

    int updateByPrimaryKey(JtRole record);
}