package xyz.sadli.dao;

import org.springframework.stereotype.Repository;
import xyz.sadli.entity.JtActivityPlayer;

@Repository
public interface JtActivityPlayerMapper {

    int deleteByPrimaryKey(String id);

    int insert(JtActivityPlayer record);

    int insertSelective(JtActivityPlayer record);

    JtActivityPlayer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JtActivityPlayer record);

    int updateByPrimaryKey(JtActivityPlayer record);
}