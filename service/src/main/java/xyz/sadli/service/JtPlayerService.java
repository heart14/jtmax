package xyz.sadli.service;

import xyz.sadli.entity.JtPlayer;
import xyz.sadli.query.sys.LoginQuery;
import xyz.sadli.vo.JtPlayerVO;

import java.util.List;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/30 16:03.
 * Editored:
 */
public interface JtPlayerService {

    /**
     * 根据用户手机号密码查询用户，用于登录
     *
     * @param loginQuery
     * @return
     */
    JtPlayer queryPlayerByPhoneNumberAndPassword(LoginQuery loginQuery);

    /**
     * 根据用户uid查询用户信息
     *
     * @param uid
     * @return
     */
    JtPlayerVO queryPlayerByUid(String uid);

    /**
     * 查询所有用户列表
     *
     * @return
     */
    List<JtPlayerVO> queryPlayerList();

    /**
     * 更新用户状态
     *
     * @param status
     * @return
     */
    void editPlayerStatus(String uid, int status);
}
