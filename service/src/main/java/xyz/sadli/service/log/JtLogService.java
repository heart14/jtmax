package xyz.sadli.service.log;

import xyz.sadli.entity.JtLog;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/11/20 11:32.
 * Editored:
 */
public interface JtLogService {

    /**
     * 保存操作日志
     * @param record
     */
    void saveJtLog(JtLog record);
}
