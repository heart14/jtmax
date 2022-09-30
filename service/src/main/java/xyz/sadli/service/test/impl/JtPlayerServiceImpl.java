package xyz.sadli.service.test.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtPlayerMapper;
import xyz.sadli.entity.JtPlayer;
import xyz.sadli.exception.SysException;
import xyz.sadli.service.test.JtPlayerService;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/30 16:03.
 * Editored:
 */
@Service
public class JtPlayerServiceImpl implements JtPlayerService {

    private final JtPlayerMapper playerMapper;

    public JtPlayerServiceImpl(JtPlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @Override
    public JtPlayer queryPlayerByPhoneNumberAndPassword(String phoneNumber, String password) {

        Assert.hasLength(phoneNumber, "参数异常");
        Assert.hasLength(password, "参数异常");

        JtPlayer jtPlayer = playerMapper.selectPlayerByPhoneNumberAndPassword(phoneNumber, password);
        if (jtPlayer == null) {
            throw new SysException(ErrCodeEnums.LOGIN_EXCEPTION.getCode(), ErrCodeEnums.LOGIN_EXCEPTION.getMsg());
        }
        return jtPlayer;
    }
}
