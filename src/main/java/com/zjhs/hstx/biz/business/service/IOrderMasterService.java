package com.zjhs.hstx.biz.business.service;

import com.zjhs.hstx.biz.business.bean.OrderMaster;
import com.baomidou.mybatisplus.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
public interface IOrderMasterService extends IService<OrderMaster> {

    /**
     * 本周营业额度
     * @return BigDecimal
     */
    BigDecimal selectWeekMoney();

    /**
     * 本月营业额度
     * @return BigDecimal
     */
    BigDecimal selectMonMoney();
}
