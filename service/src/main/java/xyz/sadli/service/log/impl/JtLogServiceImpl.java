package xyz.sadli.service.log.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.dao.JtLogMapper;
import xyz.sadli.entity.JtLog;
import xyz.sadli.service.log.JtLogService;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/11/20 11:33.
 * Editored:
 */
@Service
public class JtLogServiceImpl implements JtLogService {

    public static final Logger log = LoggerFactory.getLogger(JtLogServiceImpl.class);

    private final JtLogMapper jtLogMapper;

    public JtLogServiceImpl(JtLogMapper jtLogMapper) {
        this.jtLogMapper = jtLogMapper;
    }

    @Override
    public void saveJtLog(JtLog record) {
        if (record != null) {
            jtLogMapper.insertSelective(record);
            log.info("操作日志保存成功 :record={}", record);
        }
    }
}
