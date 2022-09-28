package com.lxk.mgr.service.impl;

import com.lxk.mgr.entity.Permission;
import com.lxk.mgr.mapper.PermissionMapper;
import com.lxk.mgr.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限列表 服务实现类
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 09:43:47
 */
@Service
@Slf4j
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
