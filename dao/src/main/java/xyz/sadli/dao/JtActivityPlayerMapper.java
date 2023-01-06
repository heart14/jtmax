package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtActivityPlayer;

@Mapper
public interface JtActivityPlayerMapper {

    int deleteByPrimaryKey(String id);

    int insert(JtActivityPlayer record);

    int insertSelective(JtActivityPlayer record);

    JtActivityPlayer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JtActivityPlayer record);

    int updateByPrimaryKey(JtActivityPlayer record);
}