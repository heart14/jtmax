package xyz.sadli.test;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.sadli.domain.JtActivityPlayerInfo;
import xyz.sadli.query.activity.ActivityPlayerPageQuery;
import xyz.sadli.service.JtActivityService;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/17 17:10.
 * Editored:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityPlayerInfoTest {

    @Autowired
    private JtActivityService activityService;

    @Test
    public void activityPlayerInfoTest() {
        ActivityPlayerPageQuery query = new ActivityPlayerPageQuery();
        query.setPage(1);
        query.setLimit(3);

        PageInfo<JtActivityPlayerInfo> pageList = activityService.queryActivityPlayerPageList(query);
        System.out.println(pageList);
    }
}
