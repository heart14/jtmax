package xyz.sadli.dao;

import org.springframework.stereotype.Repository;
import xyz.sadli.entity.JtActivity;

@Repository
public interface JtActivityMapper {

    int deleteByPrimaryKey(String activityId);

    int insert(JtActivity record);

    int insertSelective(JtActivity record);

    JtActivity selectByPrimaryKey(String activityId);

    int updateByPrimaryKeySelective(JtActivity record);

    int updateByPrimaryKey(JtActivity record);
}