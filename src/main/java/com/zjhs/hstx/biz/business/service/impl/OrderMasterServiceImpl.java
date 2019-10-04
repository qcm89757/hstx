package com.zjhs.hstx.biz.business.service.impl;

import com.zjhs.hstx.biz.business.bean.OrderMaster;
import com.zjhs.hstx.biz.business.dao.OrderMasterMapper;
import com.zjhs.hstx.biz.business.service.IOrderMasterService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Service
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements IOrderMasterService {


    private final OrderMasterMapper orderMasterMapper;

    @Autowired
    public OrderMasterServiceImpl(OrderMasterMapper orderMasterMapper) {
        this.orderMasterMapper = orderMasterMapper;
    }

    @Override
    public BigDecimal selectWeekMoney() {
        return orderMasterMapper.getWeekMoney();
    }

    @Override
    public BigDecimal selectMonMoney() {
        return orderMasterMapper.getMonMoney();
    }
}
