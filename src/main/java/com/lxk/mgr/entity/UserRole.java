package com.lxk.mgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxk.mgr.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-22 18:26:57
 */
@Data
@TableName("t_user_role")
@ApiModel(value = "UserRole对象", description = "用户角色表")
public class UserRole extends BaseEntity {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("角色ID")
    private Long roleId;

}
