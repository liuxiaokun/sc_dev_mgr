package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.entity.User;
import com.lxk.mgr.producer.Producer;
import com.lxk.mgr.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.mgr.controller.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 16:18:41
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController<User> {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "", name = "新增")
    public RO add(HttpServletRequest request, @RequestBody User user) {
        log.info("add:{}", user);
        userService.save(packAddBaseProps(user, request));
        return RO.success();
    }

    @GetMapping(value = "/{id}", name = "查看")
    public RO view(@PathVariable("id") Long id) {
        log.info("view by id:{}", id);
        User user = userService.getById(id);
        return RO.success(user);
    }

    @PatchMapping(value = "/{id}", name = "修改")
    public RO patchUpdate(@PathVariable("id") Long id, HttpServletRequest request, User user) {
        log.info("Patch modify Id:{}", id);
        user.setModifiedBy(getUserId(request));
        user.setModifiedDate(LocalDateTime.now());
        userService.updateById(user);
        return RO.success();
    }

    @DeleteMapping(value = "/{id}", name = "删除")
    public RO remove(HttpServletRequest request, @PathVariable("id") Long id) {
        log.info("delete by id:{}", id);
        userService.removeById(id);
        return RO.success();
    }

    @GetMapping(value = "", name = "列表")
    public RO list(User user, Integer pageNum, Integer pageSize) {
        log.info("list param:{}, page:{}, size:{}", user, pageNum, pageSize);
        Page<User> page = new Page<>(pageNum, pageSize);
        Page<User> pageList = userService.page(page);
        return RO.success(pageList);
    }

    @Autowired
    private Producer producer;
    @GetMapping(value = "msg")
    public RO msg() {
        producer.sendMsg("msg");
        return RO.success();
    }

}
