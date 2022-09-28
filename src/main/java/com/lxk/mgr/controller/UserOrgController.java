package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.entity.UserOrg;
import com.lxk.mgr.service.UserOrgService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.mgr.controller.base.BaseController;

/**
 * <p>
 * 用户部门关系表 前端控制器
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 16:18:41
 */
@RestController
@RequestMapping("/userOrg")
@Slf4j
public class UserOrgController extends BaseController<UserOrg> {

    private final UserOrgService userOrgService;

    public UserOrgController(UserOrgService userOrgService) {
        this.userOrgService = userOrgService;
    }

    @PostMapping(value = "", name = "新增")
    public RO add(HttpServletRequest request, @RequestBody UserOrg userOrg) {
        log.info("add:{}", userOrg);
        userOrgService.save(packAddBaseProps(userOrg, request));
        return RO.success();
    }

    @GetMapping(value = "/{id}", name = "查看")
    public RO view(@PathVariable("id") Long id) {
        log.info("view by id:{}", id);
        UserOrg userOrg = userOrgService.getById(id);
        return RO.success(userOrg);
    }

    @PatchMapping(value = "/{id}", name = "修改")
    public RO patchUpdate(@PathVariable("id") Long id, HttpServletRequest request, UserOrg userOrg) {
        log.info("Patch modify Id:{}", id);
        userOrg.setModifiedBy(getUserId(request));
        userOrg.setModifiedDate(LocalDateTime.now());
        userOrgService.updateById(userOrg);
        return RO.success();
    }

    @DeleteMapping(value = "/{id}", name = "删除")
    public RO remove(HttpServletRequest request, @PathVariable("id") Long id) {
        log.info("delete by id:{}", id);
        userOrgService.removeById(id);
        return RO.success();
    }

    @GetMapping(value = "", name = "列表")
    public RO list(UserOrg userOrg, Integer pageNum, Integer pageSize) {
        log.info("list param:{}, page:{}, size:{}", userOrg, pageNum, pageSize);
        Page<UserOrg> page = new Page<>(pageNum, pageSize);
        Page<UserOrg> pageList = userOrgService.page(page);
        return RO.success(pageList);
    }

}
