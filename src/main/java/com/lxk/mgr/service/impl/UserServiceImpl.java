package com.lxk.mgr.service.impl;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.mapper.UserMapper;
import com.lxk.mgr.entity.User;
import com.lxk.mgr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:02
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }
}
