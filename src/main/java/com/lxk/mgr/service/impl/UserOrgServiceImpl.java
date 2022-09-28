package com.lxk.mgr.service.impl;

import com.lxk.mgr.entity.UserOrg;
import com.lxk.mgr.mapper.UserOrgMapper;
import com.lxk.mgr.service.UserOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户部门关系表 服务实现类
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 09:43:47
 */
@Service
@Slf4j
public class UserOrgServiceImpl extends ServiceImpl<UserOrgMapper, UserOrg> implements UserOrgService {

}
