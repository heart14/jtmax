package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtPlayerRole;

import java.util.List;

@Mapper
public interface JtPlayerRoleMapper {

    int deleteByPrimaryKey(String uid);

    int insert(JtPlayerRole record);

    int insertSelective(JtPlayerRole record);

    JtPlayerRole selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(JtPlayerRole record);

    int updateByPrimaryKey(JtPlayerRole record);

}