package com.lxk.mgr.service.impl;

import com.lxk.mgr.entity.User;
import com.lxk.mgr.mapper.UserMapper;
import com.lxk.mgr.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 09:43:47
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
