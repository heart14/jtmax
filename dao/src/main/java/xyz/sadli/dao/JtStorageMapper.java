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
     * TODO 还有个问题，service层接口使用了泛型接收子类作为参数，dao层这里，却依然定义的父类作为参数，测试下来，查询没问题，但是这样真的ok吗？
     * @param query
     * @return
     */
    List<JtStorage> selectStorageListByQuery(StorageBasePageQuery query);
}