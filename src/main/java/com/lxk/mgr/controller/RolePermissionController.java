package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.entity.RolePermission;
import com.lxk.mgr.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.mgr.controller.base.BaseController;

/**
 * <p>
 * 角色权限关系表 前端控制器
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 09:43:47
 */
@RestController
@RequestMapping("/rolePermission")
@Slf4j
public class RolePermissionController extends BaseController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping(value = "", name = "新增")
    public RO add(HttpServletRequest request, RolePermission rolePermission) {
        log.info("add:{}", rolePermission);
        rolePermissionService.save(rolePermission);
        return RO.success();
    }

    @GetMapping(value = "/{id}", name = "查看")
    public RO view(@PathVariable("id") Long id) {
        log.info("view by id:{}", id);
        RolePermission rolePermission = rolePermissionService.getById(id);
        return RO.success(rolePermission);
    }

    @PatchMapping(value = "/{id}", name = "修改")
    public RO patchUpdate(@PathVariable("id") Long id, HttpServletRequest request, RolePermission rolePermission) {
        log.info("Patch modify Id:{}", id);
        rolePermission.setModifiedBy(getUserId(request));
        rolePermission.setModifiedDate(LocalDateTime.now());
        rolePermissionService.updateById(rolePermission);
        return RO.success();
    }

    @DeleteMapping(value = "/{id}", name = "删除")
    public RO remove(HttpServletRequest request, @PathVariable("id") Long id) {
        log.info("delete by id:{}", id);
        rolePermissionService.removeById(id);
        return RO.success();
    }

    @GetMapping(value = "", name = "列表")
    public RO list(RolePermission rolePermission, Integer pageNum, Integer pageSize) {
        log.info("list param:{}, page:{}, size:{}", rolePermission, pageNum, pageSize);
        Page<RolePermission> page = new Page<>(pageNum, pageSize);
        Page<RolePermission> pageList = rolePermissionService.page(page);
        return RO.success(pageList);
    }

}
