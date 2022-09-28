package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.entity.Permission;
import com.lxk.mgr.service.PermissionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.mgr.controller.base.BaseController;

/**
 * <p>
 * 权限列表 前端控制器
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 16:18:41
 */
@RestController
@RequestMapping("/permission")
@Slf4j
public class PermissionController extends BaseController<Permission> {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping(value = "", name = "新增")
    public RO add(HttpServletRequest request, @RequestBody Permission permission) {
        log.info("add:{}", permission);
        permissionService.save(packAddBaseProps(permission, request));
        return RO.success();
    }

    @GetMapping(value = "/{id}", name = "查看")
    public RO view(@PathVariable("id") Long id) {
        log.info("view by id:{}", id);
        Permission permission = permissionService.getById(id);
        return RO.success(permission);
    }

    @PatchMapping(value = "/{id}", name = "修改")
    public RO patchUpdate(@PathVariable("id") Long id, HttpServletRequest request, Permission permission) {
        log.info("Patch modify Id:{}", id);
        permission.setModifiedBy(getUserId(request));
        permission.setModifiedDate(LocalDateTime.now());
        permissionService.updateById(permission);
        return RO.success();
    }

    @DeleteMapping(value = "/{id}", name = "删除")
    public RO remove(HttpServletRequest request, @PathVariable("id") Long id) {
        log.info("delete by id:{}", id);
        permissionService.removeById(id);
        return RO.success();
    }

    @GetMapping(value = "", name = "列表")
    public RO list(Permission permission, Integer pageNum, Integer pageSize) {
        log.info("list param:{}, page:{}, size:{}", permission, pageNum, pageSize);
        Page<Permission> page = new Page<>(pageNum, pageSize);
        Page<Permission> pageList = permissionService.page(page);
        return RO.success(pageList);
    }

}
