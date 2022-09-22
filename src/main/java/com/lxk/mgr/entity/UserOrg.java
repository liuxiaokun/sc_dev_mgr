package com.lxk.mgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxk.mgr.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户部门关系表
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-22 18:26:57
 */
@Data
@TableName("t_user_org")
@ApiModel(value = "UserOrg对象", description = "用户部门关系表")
public class UserOrg extends BaseEntity {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("组织部门ID")
    private Long orgId;
}
