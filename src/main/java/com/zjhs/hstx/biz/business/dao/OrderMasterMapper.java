package com.zjhs.hstx.biz.business.dao;

import com.zjhs.hstx.biz.business.bean.OrderMaster;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Component
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {

    /**
     * 查询本周的营业额
     * @return
     */
    BigDecimal getWeekMoney();
    /**
     * 查询当月的营业额
     * @return
     */
    BigDecimal getMonMoney();
}
