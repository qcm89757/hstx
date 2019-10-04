package com.zjhs.hstx.biz.business.dao;

import com.zjhs.hstx.biz.business.bean.ProductInfo;
import com.zjhs.hstx.biz.business.bean.ProductType;
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
public interface ProductTypeMapper extends BaseMapper<ProductType> {
    /**
     * 	添加商品类型
     * @param t_name
     * @return int
     */
    int InsertType(String t_name);

    /**
     * 	对商品类型进行修改
     */
    int updateType(ProductType protype);

    /**
     * 查询所有的类型
     * @return List
     */
    List<ProductType> getAllCrate();

    /**
     * 查询某个类型下所有的商品
     * @param tId
     * @return List
     */

    List<ProductInfo> getInfoByCrateId(Integer tId);
    /**
     * 删除商品类型
     * @param tId
     * @return int
     */
    int removeType(Integer tId);
}
