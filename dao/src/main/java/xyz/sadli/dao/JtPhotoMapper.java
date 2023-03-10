package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtPhoto;
import xyz.sadli.query.banner.BannerPageQuery;
import xyz.sadli.query.photo.PhotoPageQuery;
import xyz.sadli.vo.JtBannerVO;
import xyz.sadli.vo.JtPhotoVO;

import java.util.List;

@Mapper
public interface JtPhotoMapper {

    int deleteByPrimaryKey(String photoId);

    int insert(JtPhoto record);

    int insertSelective(JtPhoto record);

    JtPhoto selectByPrimaryKey(String photoId);

    int updateByPrimaryKeySelective(JtPhoto record);

    int updateByPrimaryKey(JtPhoto record);

    /**
     * 根据query查询photoVo集合
     *
     * @param query
     * @return
     */
    List<JtPhotoVO> selectPhotoVOListByQuery(PhotoPageQuery query);
}