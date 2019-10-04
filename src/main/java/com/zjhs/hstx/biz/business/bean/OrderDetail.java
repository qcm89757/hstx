package com.zjhs.hstx.biz.business.bean;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Data
@Accessors(chain = true)
@TableName("order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单详情ID
     */
    @TableId("detail_id")
    private String detailId;
    /**
     * 订单ID
     */
    @TableField("order_id")
    private String orderId;
    /**
     * 商品ID
     */
    @TableField("product_id")
    private Integer productId;
    /**
     * 商品名称
     */
    @TableField("product_name")
    private String productName;
    /**
     * 当前价格,单位分
     */
    @TableField("product_price")
    private BigDecimal productPrice;
    /**
     * 商品数量
     */
    @TableField("product_quantity")
    private Integer productQuantity;
    /**
     * 商品小图
     */
    @TableField("product_icon")
    private String productIcon;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;



}
