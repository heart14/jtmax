package xyz.sadli.test;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.sadli.query.banner.BannerPageQuery;
import xyz.sadli.query.photo.PhotoPageQuery;
import xyz.sadli.service.JtBannerService;
import xyz.sadli.vo.JtBannerVO;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/3/8 21:55.
 * Editored:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BannerTest {

    @Autowired
    private JtBannerService bannerService;

    @Test
    public void test() {
        BannerPageQuery bannerPageQuery = new BannerPageQuery();
        bannerPageQuery.setLimit(10);
        bannerPageQuery.setPage(0);

        PageInfo<JtBannerVO> pageInfo = bannerService.queryBannerPageList(bannerPageQuery);
        System.out.println(pageInfo);
    }
}
