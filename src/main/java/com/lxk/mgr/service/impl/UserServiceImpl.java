package com.lxk.mgr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxk.mgr.entity.User;
import com.lxk.mgr.mapper.UserMapper;
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
    public PageInfo<User> getAll() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.selectAll();
        return new PageInfo<>(users);
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }
}
