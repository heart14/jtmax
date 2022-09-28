package xyz.sadli.service.test;

import xyz.sadli.entity.JtPlayer;
import xyz.sadli.entity.Photo;

import java.util.List;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:52.
 * Editored:
 */
public interface PhotoService {

    List<Photo> dbTest(int photoStatus);

    List<JtPlayer> playerTest();

}
