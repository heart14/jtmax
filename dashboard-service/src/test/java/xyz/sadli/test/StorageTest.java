package xyz.sadli.test;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.sadli.entity.JtStorage;
import xyz.sadli.query.storage.PhotoPageQuery;
import xyz.sadli.service.JtStorageService;

/**
 * About:
 * Other:
 * Created: wfli on 2023/2/10 16:32.
 * Editored:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageTest {

    @Autowired
    private JtStorageService storageService;

    @Test
    public void pageList(){
        PhotoPageQuery photoPageQuery = new PhotoPageQuery();
        photoPageQuery.setPage(1);
        photoPageQuery.setLimit(5);

        photoPageQuery.setStatus(0);


        PageInfo<JtStorage> pageInfo = storageService.queryStoragePageList(photoPageQuery);
        System.out.println(pageInfo);
    }
}
