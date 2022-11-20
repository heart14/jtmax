package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtLog;

@Mapper
public interface JtLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(JtLog record);

    int insertSelective(JtLog record);

    JtLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(JtLog record);

    int updateByPrimaryKey(JtLog record);
}