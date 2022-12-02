package xyz.sadli.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.sadli.service.JtPlayerService;
import xyz.sadli.vo.JtPlayerVO;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/2 0:28.
 * Editored:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private JtPlayerService jtPlayerService;

    @Test
    public void getUserInfo() {
        JtPlayerVO jtPlayerVO = jtPlayerService.queryPlayerByUid("0x001");
        System.out.println(jtPlayerVO);
    }
}