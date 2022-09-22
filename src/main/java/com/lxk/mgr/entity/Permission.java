package com.lxk.mgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxk.mgr.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 权限列表
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-22 18:26:56
 */
@Data
@TableName("t_permission")
@ApiModel(value = "Permission对象", description = "权限列表")
public class Permission extends BaseEntity {

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("1:URL 2:按钮 3:菜单")
    private Byte type;

    @ApiModelProperty("权限值")
    private String value;

    @ApiModelProperty("是否启用")
    private Byte enabled;

}
