package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtLog;

import java.util.List;

@Mapper
public interface JtLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(JtLog record);

    int insertSelective(JtLog record);

    JtLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(JtLog record);

    int updateByPrimaryKey(JtLog record);

    /**
     * 查询所有操作日志
     * @return
     */
    List<JtLog> selectAllJtLog();

    /**
     * 根据uid查询操作日志
     * @param uid
     * @return
     */
    List<JtLog> selectJtLogListByUid(String uid);

}