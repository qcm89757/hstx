package com.zjhs.hstx.biz.business.service.impl;

import com.zjhs.hstx.biz.business.bean.ProductInfo;
import com.zjhs.hstx.biz.business.bean.ProductType;
import com.zjhs.hstx.biz.business.dao.ProductTypeMapper;
import com.zjhs.hstx.biz.business.service.IProductTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    private final ProductTypeMapper productTypeMapper;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeMapper productTypeMapper) {
        this.productTypeMapper = productTypeMapper;
    }
}
