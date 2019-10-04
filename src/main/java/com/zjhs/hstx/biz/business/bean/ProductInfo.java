package com.zjhs.hstx.biz.business.bean;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
@TableName("product_info")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品id
     */
    @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;
    /**
     * 类型id
     */
    @TableField("t_id")
    private Integer tId;
    @TableField("p_img")
    private String pImg;
    /**
     * 产品名称
     */
    @TableField("p_name")
    private String pName;
    /**
     * 产品价格
     */
    @TableField("p_money")
    private BigDecimal pMoney;
    /**
     * 产品描述
     */
    @TableField("p_depict")
    private String pDepict;
    /**
     * 产品份量
     */
    @TableField("p_num")
    private Integer pNum;
    /**
     * 上架
     */
    @TableField("put_away")
    private Integer putAway;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;



}
