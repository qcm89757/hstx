package com.zjhs.hstx.biz.business.bean;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Data
@Accessors(chain = true)
@TableName("product_type")
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;
    @TableField("t_name")
    private String tName;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;



}
