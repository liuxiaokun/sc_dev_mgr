package com.lxk.mgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxk.mgr.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-22 18:26:56
 */
@Data
@TableName("t_role")
@ApiModel(value = "Role对象", description = "角色")
public class Role extends BaseEntity {

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("是否启用")
    private Byte enabled;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("备注")
    private String remark;

}
