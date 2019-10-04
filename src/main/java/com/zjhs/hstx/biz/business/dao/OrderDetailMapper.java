package com.zjhs.hstx.biz.business.dao;

import com.zjhs.hstx.biz.business.bean.OrderDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * <p>
 * 订单详情表 Mapper 接口
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Component
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
    /**
     * 删除订单
     * @param detailId
     * @return
     */
    int deleteByPrimaryKey(String detailId);

}
