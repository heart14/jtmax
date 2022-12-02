package xyz.sadli.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xyz.sadli.dao.JtLogMapper;
import xyz.sadli.entity.JtLog;
import xyz.sadli.service.JtLogService;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/11/20 11:33.
 * Editored:
 */
@Service
@CacheConfig(cacheNames = "jtmax:log")
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

    @Override
    public List<JtLog> queryAllJtLog() {
        return jtLogMapper.selectAllJtLog();
    }

    @Override
    @Cacheable(key = "#uid")//查询时先从redis查询缓存数据，有则直接返回，没有则执行方法内容，并将方法返回值存入redis缓存
    public List<JtLog> queryJtLogListByUid(String uid) {
        return jtLogMapper.selectJtLogListByUid(uid);
    }

    @Override
    @Cacheable(key = "#logId")
    public JtLog queryJtLogById(String logId) {
        return jtLogMapper.selectByPrimaryKey(logId);
    }
}
