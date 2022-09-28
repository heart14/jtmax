package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtPlayerRole;

@Mapper
public interface JJtPlayerRoleMapper {
    int deleteByPrimaryKey(String uid);

    int insert(JtPlayerRole record);

    int insertSelective(JtPlayerRole record);

    JtPlayerRole selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(JtPlayerRole record);

    int updateByPrimaryKey(JtPlayerRole record);
}