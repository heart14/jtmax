package xyz.sadli.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.sadli.service.JtRoleService;
import xyz.sadli.vo.JtRoleVO;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/3 21:45.
 * Editored:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

    @Autowired
    private JtRoleService roleService;

    @Test
    public void roleList(){
        List<JtRoleVO> jtRoleVOList = roleService.queryRoleList();
        System.out.println(jtRoleVOList);
    }
}
