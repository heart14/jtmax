package xyz.sadli.service.test.impl;

import org.springframework.stereotype.Service;
import xyz.sadli.dao.PhotoMapper;
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

    public PhotoServiceImpl(PhotoMapper photoMapper) {
        this.photoMapper = photoMapper;
    }

    @Override
    public List<Photo> dbTest(int photoStatus) {
        return photoMapper.selectAll(photoStatus);
    }
}
