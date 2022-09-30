package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtRole;

import java.util.List;

@Mapper
public interface JtRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(JtRole record);

    int insertSelective(JtRole record);

    JtRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(JtRole record);

    int updateByPrimaryKey(JtRole record);

    /**
     * 根据uid关联查询所有角色
     * @param uid
     * @return
     */
    List<JtRole> selectRolesByUid(String uid);

}