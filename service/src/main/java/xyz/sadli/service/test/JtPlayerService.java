package xyz.sadli.service.test;

import xyz.sadli.entity.JtPlayer;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/30 16:03.
 * Editored:
 */
public interface JtPlayerService {

    JtPlayer queryPlayerByPhoneNumberAndPassword(String phoneNumber, String password);
}
