package com.zjhs.hstx.biz.business.service;

import com.zjhs.hstx.biz.business.bean.ProductInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
public interface IProductInfoService extends IService<ProductInfo> {

    /**
     *	 通过id查询商品信息
     * @param pId
     * @return ProductInfo
     */
    ProductInfo getInfoByPid(Integer pId);

    int removeByPrimaryKey(Integer pId);

    int modifyByPrimaryKey(ProductInfo record);

    List<ProductInfo> selectAllPro();

    List<ProductInfo> selectProByName(String pName);

    int modifyPutAwayByPid(Integer p_id, int i);
}
