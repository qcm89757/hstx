package com.zjhs.hstx.biz.business.bean;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Data
@Accessors(chain = true)
@TableName("order_master")
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "order_id", type = IdType.UUID)
    private String orderId;
    /**
     * 买家名字
     */
    @TableField("buyer_name")
    private String buyerName;
    /**
     * 买家电话
     */
    @TableField("buyer_phone")
    private String buyerPhone;
    /**
     * 买家地址
     */
    @TableField("buyer_address")
    private String buyerAddress;
    /**
     * 买家微信openId
     */
    @TableField("buyer_openid")
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    @TableField("order_amount")
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认为已下单
     */
    @TableField("order_status")
    private Integer orderStatus;
    /**
     * 支付状态, 默认未支付
     */
    @TableField("pay_status")
    private Integer payStatus;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_tiem", fill = FieldFill.UPDATE)
    private Date updateTiem;



}
