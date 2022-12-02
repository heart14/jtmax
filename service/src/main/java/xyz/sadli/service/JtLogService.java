package xyz.sadli.service;

import xyz.sadli.entity.JtLog;

import java.util.List;

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

    /**
     * 查询所有操作日志
     * @return
     */
    List<JtLog> queryAllJtLog();

    /**
     * 根据uid查询操作日志
     * @param uid
     * @return
     */
    List<JtLog> queryJtLogListByUid(String uid);

    /**
     * 根据日志id查询操作日志
     * @param logId
     * @return
     */
    JtLog queryJtLogById(String logId);
}
