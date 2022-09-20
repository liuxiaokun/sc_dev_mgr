package com.lxk.mgr.mapper;

//import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxk.mgr.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:02
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> selectAll();
}
