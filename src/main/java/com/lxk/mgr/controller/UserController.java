package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.BaseController;
import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:00
 */
@RestController
@RequestMapping("users")
@Slf4j
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public RO user(@PathVariable Long id) {
        return RO.success(userService.getById(id));
    }
}
