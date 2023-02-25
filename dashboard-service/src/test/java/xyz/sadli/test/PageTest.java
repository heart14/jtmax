package xyz.sadli.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.sadli.query.photo.BannerPageQuery;
import xyz.sadli.query.photo.PhotoPageQuery;
import xyz.sadli.service.JtStorageService;

/**
 * About:
 * Other:
 * Created: lwf14 on 2023/2/26 1:58.
 * Editored:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTest {

    @Autowired
    private JtStorageService storageService;

    @Test
    public void test(){
        PhotoPageQuery photoPageQuery = new PhotoPageQuery();
        photoPageQuery.setLimit(10);
        photoPageQuery.setPage(0);
        System.out.println("1  "+photoPageQuery);

        BannerPageQuery bannerPageQuery = new BannerPageQuery();
        bannerPageQuery.setLimit(10);
        bannerPageQuery.setPage(0);
        System.out.println("2  "+bannerPageQuery);

        System.out.println("3  "+storageService.queryStoragePageList(photoPageQuery));
        System.out.println("4  "+storageService.queryStoragePageList(bannerPageQuery));
    }
}
