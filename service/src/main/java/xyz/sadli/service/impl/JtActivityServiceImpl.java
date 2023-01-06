package xyz.sadli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.dao.JtActivityMapper;
import xyz.sadli.dao.JtActivityPlayerMapper;
import xyz.sadli.entity.JtActivity;
import xyz.sadli.query.activity.ActivityPageQuery;
import xyz.sadli.service.JtActivityService;

import java.util.List;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/6 11:23.
 * Editored:
 */
@Service
public class JtActivityServiceImpl implements JtActivityService {

    public static final Logger log = LoggerFactory.getLogger(JtActivityServiceImpl.class);

    private final JtActivityMapper activityMapper;
    private final JtActivityPlayerMapper activityPlayerMapper;

    public JtActivityServiceImpl(JtActivityMapper activityMapper, JtActivityPlayerMapper activityPlayerMapper) {
        this.activityMapper = activityMapper;
        this.activityPlayerMapper = activityPlayerMapper;
    }

    @Override
    public PageInfo<JtActivity> queryActivityPageList(ActivityPageQuery query) {
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<JtActivity> list = activityMapper.selectAllActivity(query);
        return new PageInfo<>(list);
    }
}
