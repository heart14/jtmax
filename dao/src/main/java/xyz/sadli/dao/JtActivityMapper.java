package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.sadli.entity.JtActivity;
import xyz.sadli.query.activity.ActivityPageQuery;
import xyz.sadli.query.activity.SaveActivityQuery;
import xyz.sadli.query.permission.SavePermissionQuery;

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

    /**
     * 根据主键更新SaveActivityQuery传递的参数
     * @param query
     * @return
     */
    int updateByPrimaryKeyAndQueryParams(@Param("activityId") String activityId, @Param("query") SaveActivityQuery query);
}