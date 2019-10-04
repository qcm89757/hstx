package com.zjhs.hstx.biz.business.dao;

import com.zjhs.hstx.biz.business.bean.ProductInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Component
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    /**
     * 查询所有商品
     * @return
     */
    List<ProductInfo> getAllPro();
    /**
     * 模糊查询
     * @return
     */
    List<ProductInfo> getProByName(String pName);

//    /**
//     * 	添加产品
//     * @param product
//     * @return
//     */
//    int insert(ProductInfo product);

    /**
     * 	根据id删除一个产品
     * @param pId
     * @return
     */
    int deleteByPrimaryKey(int pId);


    /**
     * 	通过id查询商品信息
     * @param pId
     * @return
     */
    ProductInfo selectByPrimaryKey(Integer pId);

    /**
     *	 修改商品信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(ProductInfo record);

    int updatePutAwayByPid(Integer pid,Integer putAway);
}
