package com.lxk.mgr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lxk.mgr.entity.User;

import java.util.List;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:01
 */
public interface UserService extends IService<User> {

    PageInfo<User> getAll();

    User getById(Long id);
}
