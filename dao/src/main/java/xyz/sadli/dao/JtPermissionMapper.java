package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtPermission;

@Mapper
public interface JtPermissionMapper {
    int deleteByPrimaryKey(String permId);

    int insert(JtPermission record);

    int insertSelective(JtPermission record);

    JtPermission selectByPrimaryKey(String permId);

    int updateByPrimaryKeySelective(JtPermission record);

    int updateByPrimaryKey(JtPermission record);
}