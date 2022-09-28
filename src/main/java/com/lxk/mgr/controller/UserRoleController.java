package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.entity.UserRole;
import com.lxk.mgr.service.UserRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.mgr.controller.base.BaseController;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 09:43:47
 */
@RestController
@RequestMapping("/userRole")
@Slf4j
public class UserRoleController extends BaseController {

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping(value = "", name = "新增")
    public RO add(HttpServletRequest request, UserRole userRole) {
        log.info("add:{}", userRole);
        userRoleService.save(userRole);
        return RO.success();
    }

    @GetMapping(value = "/{id}", name = "查看")
    public RO view(@PathVariable("id") Long id) {
        log.info("view by id:{}", id);
        UserRole userRole = userRoleService.getById(id);
        return RO.success(userRole);
    }

    @PatchMapping(value = "/{id}", name = "修改")
    public RO patchUpdate(@PathVariable("id") Long id, HttpServletRequest request, UserRole userRole) {
        log.info("Patch modify Id:{}", id);
        userRole.setModifiedBy(getUserId(request));
        userRole.setModifiedDate(LocalDateTime.now());
        userRoleService.updateById(userRole);
        return RO.success();
    }

    @DeleteMapping(value = "/{id}", name = "删除")
    public RO remove(HttpServletRequest request, @PathVariable("id") Long id) {
        log.info("delete by id:{}", id);
        userRoleService.removeById(id);
        return RO.success();
    }

    @GetMapping(value = "", name = "列表")
    public RO list(UserRole userRole, Integer pageNum, Integer pageSize) {
        log.info("list param:{}, page:{}, size:{}", userRole, pageNum, pageSize);
        Page<UserRole> page = new Page<>(pageNum, pageSize);
        Page<UserRole> pageList = userRoleService.page(page);
        return RO.success(pageList);
    }

}
