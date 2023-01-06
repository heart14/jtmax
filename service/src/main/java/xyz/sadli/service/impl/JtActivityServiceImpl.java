package xyz.sadli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.dao.JtActivityMapper;
import xyz.sadli.dao.JtActivityPlayerMapper;
import xyz.sadli.entity.JtActivity;
import xyz.sadli.exception.SysException;
import xyz.sadli.query.activity.ActivityPageQuery;
import xyz.sadli.query.activity.SaveActivityQuery;
import xyz.sadli.service.JtActivityService;
import xyz.sadli.util.IdWorker;

import java.util.Date;
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

    @Override
    public JtActivity saveActivity(SaveActivityQuery query) {
        JtActivity activity = new JtActivity();
        String id = IdWorker.nextIdStr();
        activity.setActivityId(id);
        activity.setActivityName(query.getActivityName());
        activity.setActivityDesc(query.getActivityDesc());
        activity.setActivityTimeStart(query.getActivityTimeStart());
        activity.setActivityTimeEnd(query.getActivityTimeEnd());
        activity.setActivityPlace(query.getActivityPlace());
        activity.setActivityOrganizer(query.getActivityOrganizer());
        activity.setAssembleTime(query.getAssembleTime());
        activity.setAssemblePlace(query.getAssemblePlace());
        activity.setMinLevel(query.getMinLevel());
        activity.setMaxPlayer(query.getMaxPlayer());
        activity.setDeadline(query.getDeadline());
        activity.setRemark(query.getRemark());
        activity.setStatus(Constants.ACTIVITY_STATUS_CREATE);
        activity.setCreateTime(new Date());

        int insert = activityMapper.insertSelective(activity);
        if (insert != 1) {
            throw new SysException(ErrCodeEnums.DB_EXCEPTION.getCode(), ErrCodeEnums.DB_EXCEPTION.getMsg());
        }
        return activity;
    }
}
