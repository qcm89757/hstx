package com.zjhs.hstx.biz.business.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zjhs.hstx.base.Result;
import com.zjhs.hstx.biz.business.bean.OrderDetail;
import com.zjhs.hstx.biz.business.bean.OrderMaster;
import com.zjhs.hstx.biz.business.service.IOrderDetailService;
import com.zjhs.hstx.biz.business.service.IOrderMasterService;
import com.zjhs.hstx.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Api("订单表控制器")
@RestController
@RequestMapping("/OrderMaster")
public class OrderMasterController {

    private final IOrderMasterService orderMasterService;

    private final IOrderDetailService orderDetailService;

    @Autowired
    public OrderMasterController(IOrderMasterService orderMasterService, IOrderDetailService orderDetailService) {
        this.orderMasterService = orderMasterService;
        this.orderDetailService = orderDetailService;
    }

    @ApiOperation("新增订单")
    @RequestMapping(value = "/inserMaster",method = RequestMethod.POST)
    public Result inserMaster(HttpServletRequest request,
                              @ApiParam(name = "openId", value = "买家微信openId") @RequestParam(name = "openId") String openId,
                              @ApiParam(name = "buyerName", value = "买家名字") @RequestParam(name = "buyerName") String buyerName,
                              @ApiParam(name = "orderStatus", value = "订单状态，默认为已下单") @RequestParam(name = "orderStatus") Integer orderStatus,
                              @ApiParam(name = "payStatus", value = "支付状态, 默认未支付") @RequestParam(name = "payStatus") Integer payStatus) {
        BigDecimal productPrice = new BigDecimal(request.getParameter("productPrice"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        int productQuantity = Integer.parseInt(request.getParameter("productNum"));
        OrderDetail record = new OrderDetail();
        OrderMaster master = new OrderMaster();
        record.setProductId(productId).setProductName(productName).setProductPrice(productPrice).setProductQuantity(productQuantity);
        master.setBuyerName(buyerName).setBuyerOpenid(openId).setOrderAmount(productPrice).setOrderStatus(orderStatus).setPayStatus(payStatus);
        if(orderMasterService.insert(master) && orderDetailService.insert(record)){
            return Result.success("订单创建成功！");
        }else {
            return Result.fail("订单生成失败");
        }
    }

    /**
     * 查询当天，本周，当月和总营业额度
     */
    @ApiOperation("统计额度")
    @RequestMapping(value="/selectAllMoney",method=RequestMethod.GET)
    public Result<Map<String, Object>> selectAllMoney() {
        //当天额度
        Object today = orderMasterService.selectObj(new EntityWrapper<OrderMaster>()
                .setSqlSelect("sum(order_amount)")
                .eq("update_tiem", DateUtil.getCurYmdDate())
                .eq("pay_status", true));
        BigDecimal OneMoney = (BigDecimal) today;
        //本周额度
        BigDecimal WeekMoney = orderMasterService.selectWeekMoney();
        //本月额度
        BigDecimal MonMoney = orderMasterService.selectMonMoney();
        //所有额度
        Object AllMoney = orderMasterService.selectObj(new EntityWrapper<OrderMaster>()
                .setSqlSelect("sum(order_amount)")
                .eq("pay_status", true));
        Map<String, Object> map = new HashMap<>();
        map.put("OneMoney", OneMoney);
        map.put("WeekMoney", WeekMoney);
        map.put("MonMoney", MonMoney);
        map.put("AllMoney", AllMoney);
        return new Result<>(map);
    }

}

