package xyz.sadli.service;

import com.github.pagehelper.PageInfo;
import xyz.sadli.entity.JtActivity;
import xyz.sadli.query.activity.ActivityPageQuery;
import xyz.sadli.query.activity.SaveActivityQuery;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/6 11:22.
 * Editored:
 */
public interface JtActivityService {

    /**
     * 分页查询活动列表
     *
     * @param query
     * @return
     */
    PageInfo<JtActivity> queryActivityPageList(ActivityPageQuery query);

    /**
     * 新增活动
     *
     * @param query
     */
    JtActivity saveActivity(SaveActivityQuery query);

    /**
     * 更新活动
     *
     * @param activityId
     * @param query
     * @return
     */
    void editActivity(String activityId, SaveActivityQuery query);

    /**
     * 发布活动：将活动状态置为1
     *
     * @param activityId
     */
    void publishActivity(String activityId);

    /**
     * 删除活动（物理删除，若要逻辑删除，请使用更新状态接口）
     *
     * @param activityId
     */
    void removeActivity(String activityId);
}
