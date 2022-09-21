package com.lxk.mgr.entity.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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
    private Long id;

    /**
     * 创建人ID
     */
    private Long createdBy;

    /**
     * 创建人名字
     */
    private Long createdByName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    /**
     * 最后修改人ID
     */
    private Long modifiedBy;

    /**
     * 最后修改人名字
     */
    private Long modifiedByName;

    /**
     * 最后修改日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;

    /**
     * 数据状态
     */
    private Integer status;
}
