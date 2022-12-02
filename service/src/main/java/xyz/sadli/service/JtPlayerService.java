package xyz.sadli.service;

import xyz.sadli.entity.JtPlayer;
import xyz.sadli.vo.JtPlayerVO;

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
     * @param phoneNumber
     * @param password
     * @return
     */
    JtPlayer queryPlayerByPhoneNumberAndPassword(String phoneNumber, String password);

    /**
     * 根据用户uid查询用户信息
     *
     * @param uid
     * @return
     */
    JtPlayerVO queryPlayerByUid(String uid);
}
