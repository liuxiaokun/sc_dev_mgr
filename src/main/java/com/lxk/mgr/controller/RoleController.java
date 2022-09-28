package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.entity.Role;
import com.lxk.mgr.service.RoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.mgr.controller.base.BaseController;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 09:43:47
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController extends BaseController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(value = "", name = "新增")
    public RO add(HttpServletRequest request, Role role) {
        log.info("add:{}", role);
        roleService.save(role);
        return RO.success();
    }

    @GetMapping(value = "/{id}", name = "查看")
    public RO view(@PathVariable("id") Long id) {
        log.info("view by id:{}", id);
        Role role = roleService.getById(id);
        return RO.success(role);
    }

    @PatchMapping(value = "/{id}", name = "修改")
    public RO patchUpdate(@PathVariable("id") Long id, HttpServletRequest request, Role role) {
        log.info("Patch modify Id:{}", id);
        role.setModifiedBy(getUserId(request));
        role.setModifiedDate(LocalDateTime.now());
        roleService.updateById(role);
        return RO.success();
    }

    @DeleteMapping(value = "/{id}", name = "删除")
    public RO remove(HttpServletRequest request, @PathVariable("id") Long id) {
        log.info("delete by id:{}", id);
        roleService.removeById(id);
        return RO.success();
    }

    @GetMapping(value = "", name = "列表")
    public RO list(Role role, Integer pageNum, Integer pageSize) {
        log.info("list param:{}, page:{}, size:{}", role, pageNum, pageSize);
        Page<Role> page = new Page<>(pageNum, pageSize);
        Page<Role> pageList = roleService.page(page);
        return RO.success(pageList);
    }

}
