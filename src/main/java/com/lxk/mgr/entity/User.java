package com.lxk.mgr.entity;

import com.lxk.mgr.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:03
 */
@Data
public class User extends BaseEntity {

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;
}
