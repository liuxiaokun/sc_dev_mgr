package com.lxk.mgr.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-21 13:15
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 表主键ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建人ID
     */
    @ApiModelProperty("创建人ID")
    private Long createdBy;

    /**
     * 创建人名字
     */
    @ApiModelProperty("创建人名字")
    private String createdByName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdDate;

    /**
     * 最后修改人ID
     */
    @ApiModelProperty("最后修改人ID")
    private Long modifiedBy;

    /**
     * 最后修改人名字
     */
    @ApiModelProperty("最后修改人名字")
    private String modifiedByName;

    /**
     * 最后修改日期
     */
    @ApiModelProperty("最后修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;

    /**
     * 数据状态
     */
    @ApiModelProperty("数据状态")
    @TableLogic(value = "1", delval = "0")
    private Byte status;

    @ApiModelProperty("IP地址")
    private Integer ip;
}
