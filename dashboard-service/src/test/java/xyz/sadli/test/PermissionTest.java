package xyz.sadli.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.sadli.service.JtPermissionService;
import xyz.sadli.vo.JtPermissionVO;

import java.util.List;

/**
 * About:
 * Other:
 * Created: wfli on 2022/12/7 18:22.
 * Editored:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {

    @Autowired
    private JtPermissionService permissionService;

    @Test
    public void parentTest(){
        List<JtPermissionVO> voList = permissionService.queryPermissionList();
        System.out.println(voList);
    }
}
