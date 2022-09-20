package com.lxk.mgr.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:03
 */
@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
