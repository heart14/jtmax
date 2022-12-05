package xyz.sadli.service;

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
}
