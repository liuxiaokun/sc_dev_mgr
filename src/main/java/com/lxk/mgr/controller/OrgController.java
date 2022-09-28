package com.lxk.mgr.controller;

import com.lxk.mgr.controller.base.RO;
import com.lxk.mgr.entity.Org;
import com.lxk.mgr.service.OrgService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.mgr.controller.base.BaseController;

/**
 * <p>
 * 组织部门 前端控制器
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-28 16:18:40
 */
@RestController
@RequestMapping("/org")
@Slf4j
public class OrgController extends BaseController<Org> {

    private final OrgService orgService;

    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @PostMapping(value = "", name = "新增")
    public RO add(HttpServletRequest request, @RequestBody Org org) {
        log.info("add:{}", org);
        orgService.save(packAddBaseProps(org, request));
        return RO.success();
    }

    @GetMapping(value = "/{id}", name = "查看")
    public RO view(@PathVariable("id") Long id) {
        log.info("view by id:{}", id);
        Org org = orgService.getById(id);
        return RO.success(org);
    }

    @PatchMapping(value = "/{id}", name = "修改")
    public RO patchUpdate(@PathVariable("id") Long id, HttpServletRequest request, Org org) {
        log.info("Patch modify Id:{}", id);
        org.setModifiedBy(getUserId(request));
        org.setModifiedDate(LocalDateTime.now());
        orgService.updateById(org);
        return RO.success();
    }

    @DeleteMapping(value = "/{id}", name = "删除")
    public RO remove(HttpServletRequest request, @PathVariable("id") Long id) {
        log.info("delete by id:{}", id);
        orgService.removeById(id);
        return RO.success();
    }

    @GetMapping(value = "", name = "列表")
    public RO list(Org org, Integer pageNum, Integer pageSize) {
        log.info("list param:{}, page:{}, size:{}", org, pageNum, pageSize);
        Page<Org> page = new Page<>(pageNum, pageSize);
        Page<Org> pageList = orgService.page(page);
        return RO.success(pageList);
    }

}
