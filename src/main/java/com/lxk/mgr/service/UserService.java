package com.lxk.mgr.service;

import com.lxk.mgr.entity.User;

import java.util.List;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:01
 */
public interface UserService {

    List<User> getAll();

    User getById(Long id);
}
