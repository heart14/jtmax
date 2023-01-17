package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.domain.JtActivityPlayerInfo;
import xyz.sadli.entity.JtActivityPlayer;
import xyz.sadli.query.activity.ActivityPlayerPageQuery;

import java.util.List;

@Mapper
public interface JtActivityPlayerMapper {

    int deleteByPrimaryKey(String id);

    int insert(JtActivityPlayer record);

    int insertSelective(JtActivityPlayer record);

    JtActivityPlayer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JtActivityPlayer record);

    int updateByPrimaryKey(JtActivityPlayer record);

    /**
     * 根据ActivityPlayerPageQuery参数，查询活动报名信息
     * @param query
     * @return
     */
    List<JtActivityPlayerInfo> selectAllActivityPlayerInfo(ActivityPlayerPageQuery query);
}