package xyz.sadli.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.dao.JtActivityMapper;
import xyz.sadli.dao.JtActivityPlayerMapper;
import xyz.sadli.service.JtActivityService;

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


}
