package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtStorage;

@Mapper
public interface JtStorageMapper {

    int deleteByPrimaryKey(String id);

    int insert(JtStorage record);

    int insertSelective(JtStorage record);

    JtStorage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JtStorage record);

    int updateByPrimaryKey(JtStorage record);
}