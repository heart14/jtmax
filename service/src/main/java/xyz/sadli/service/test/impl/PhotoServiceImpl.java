package xyz.sadli.service.test.impl;

import org.springframework.stereotype.Service;
import xyz.sadli.dao.JtPlayerMapper;
import xyz.sadli.dao.PhotoMapper;
import xyz.sadli.entity.JtPlayer;
import xyz.sadli.entity.Photo;
import xyz.sadli.service.test.PhotoService;

import java.util.List;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:53.
 * Editored:
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoMapper photoMapper;

    private final JtPlayerMapper playerMapper;

    public PhotoServiceImpl(PhotoMapper photoMapper, JtPlayerMapper playerMapper) {
        this.photoMapper = photoMapper;
        this.playerMapper = playerMapper;
    }

    @Override
    public List<Photo> dbTest(int photoStatus) {
        return photoMapper.selectAll(photoStatus);
    }

    @Override
    public List<JtPlayer> playerTest() {
        return null;
    }
}
