package com.lxk.mgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxk.mgr.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-22 18:26:56
 */
@Data
@TableName("t_role_permission")
@ApiModel(value = "RolePermission对象", description = "角色权限关系表")
public class RolePermission extends BaseEntity {

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("权限ID")
    private Long permissionId;

}
