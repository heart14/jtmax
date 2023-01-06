package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtActivity;
import xyz.sadli.query.activity.ActivityPageQuery;

import java.util.List;

@Mapper
public interface JtActivityMapper {

    int deleteByPrimaryKey(String activityId);

    int insert(JtActivity record);

    int insertSelective(JtActivity record);

    JtActivity selectByPrimaryKey(String activityId);

    int updateByPrimaryKeySelective(JtActivity record);

    int updateByPrimaryKey(JtActivity record);

    /**
     * 查询所有活动信息
     *
     * @param query
     * @return
     */
    List<JtActivity> selectAllActivity(ActivityPageQuery query);
}