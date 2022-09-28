package com.lxk.mgr.service.impl;

import com.lxk.mgr.entity.Role;
import com.lxk.mgr.mapper.RoleMapper;
import com.lxk.mgr.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 09:43:47
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
