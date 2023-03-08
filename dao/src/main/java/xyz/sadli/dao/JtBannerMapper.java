package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtBanner;

@Mapper
public interface JtBannerMapper {

    int deleteByPrimaryKey(String bannerId);

    int insert(JtBanner record);

    int insertSelective(JtBanner record);

    JtBanner selectByPrimaryKey(String bannerId);

    int updateByPrimaryKeySelective(JtBanner record);

    int updateByPrimaryKey(JtBanner record);
}