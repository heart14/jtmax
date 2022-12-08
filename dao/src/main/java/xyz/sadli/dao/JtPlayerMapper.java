package xyz.sadli.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.sadli.entity.JtPlayer;

import java.util.List;

@Mapper
public interface JtPlayerMapper {

    int deleteByPrimaryKey(String uid);

    int insert(JtPlayer record);

    int insertSelective(JtPlayer record);

    JtPlayer selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(JtPlayer record);

    int updateByPrimaryKey(JtPlayer record);

    /**
     * 根据phoneNumber password查询player,用于登录验证
     *
     * @param phoneNumber
     * @param password
     * @return
     */
    JtPlayer selectPlayerByPhoneNumberAndPassword(String phoneNumber, String password);

    /**
     * 查询所有player列表
     *
     * @return
     */
    List<JtPlayer> selectAllPlayer();
}