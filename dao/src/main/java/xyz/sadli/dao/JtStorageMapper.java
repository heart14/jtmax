package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.query.storage.StorageBasePageQuery;

import java.util.List;

@Mapper
public interface JtStorageMapper {

    int deleteByPrimaryKey(String id);

    int insert(JtStorage record);

    int insertSelective(JtStorage record);

    JtStorage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JtStorage record);

    int updateByPrimaryKey(JtStorage record);

    /**
     * 根据query查询storage集合
     *
     * @param query
     * @return
     */
    List<JtStorage> selectStorageListByQuery(StorageBasePageQuery query);
}