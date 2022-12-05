package xyz.sadli.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.sadli.dao.JtPermissionMapper;
import xyz.sadli.service.JtPermissionService;
import xyz.sadli.vo.JtPermissionVO;

import java.util.List;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/12/4 21:12.
 * Editored:
 */
@Service
public class JtPermissionServiceImpl implements JtPermissionService {

    private static final Logger log = LoggerFactory.getLogger(JtPermissionServiceImpl.class);

    private final JtPermissionMapper permissionMapper;

    public JtPermissionServiceImpl(JtPermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<JtPermissionVO> queryPermissionList() {
        return null;
    }

}
