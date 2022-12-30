package xyz.sadli.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import xyz.sadli.entity.JtPermission;
import xyz.sadli.query.permission.PermissionPageQuery;
import xyz.sadli.query.permission.SavePermissionQuery;
import xyz.sadli.vo.JtPermissionVO;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/4 21:09.
 * Editored:
 */
public interface JtPermissionService {

    /**
     * 查询权限列表
     * @return
     */
    List<JtPermissionVO> queryPermissionList();

    /**
     * 分页查询权限列表
     * @param query
     * @return
     */
    PageInfo<JtPermission> queryPermissionPageList(PermissionPageQuery query);

    /**
     * 新增权限
     * @param query
     */
    JtPermission savePermission(SavePermissionQuery query);

    /**
     * 更新权限
     * @param permId
     * @param query
     * @return
     */
    void editPermission(String permId, SavePermissionQuery query);

    /**
     * (物理)删除权限
     * @param permId
     */
    void removePermission(String permId);
}
