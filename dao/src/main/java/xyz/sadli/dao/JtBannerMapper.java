package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtBanner;
import xyz.sadli.query.banner.BannerPageQuery;
import xyz.sadli.vo.JtBannerVO;

import java.util.List;

@Mapper
public interface JtBannerMapper {

    int deleteByPrimaryKey(String bannerId);

    int insert(JtBanner record);

    int insertSelective(JtBanner record);

    JtBanner selectByPrimaryKey(String bannerId);

    int updateByPrimaryKeySelective(JtBanner record);

    int updateByPrimaryKey(JtBanner record);

    /**
     * 查询当前生效展示的banner
     *
     * @return
     */
    JtBanner selectCurrentShowedBanner();

    List<JtBannerVO> selectBannerVOListByQuery(BannerPageQuery query);
}