package com.lxk.mgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxk.mgr.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 组织部门
 * </p>
 *
 * @author liuxiaokun
 * @since 2022-09-22 18:26:56
 */
@Data
@TableName("t_org")
@ApiModel(value = "Org对象", description = "组织部门")
public class Org extends BaseEntity {

    @ApiModelProperty("父ID")
    private Long pid;

    @ApiModelProperty("组织名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("描述")
    private String description;

}
