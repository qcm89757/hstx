package com.zjhs.hstx.biz.business.service.impl;

import com.zjhs.hstx.biz.business.bean.ProductInfo;
import com.zjhs.hstx.biz.business.dao.ProductInfoMapper;
import com.zjhs.hstx.biz.business.service.IProductInfoService;
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
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {

    private final ProductInfoMapper productInfoMapper;

    @Autowired
    public ProductInfoServiceImpl(ProductInfoMapper productInfoMapper) {
        this.productInfoMapper = productInfoMapper;
    }

    @Override
    public ProductInfo getInfoByPid(Integer pId) {
        return productInfoMapper.selectByPrimaryKey(pId);
    }

    @Override
    public int removeByPrimaryKey(Integer pId) {
        return productInfoMapper.deleteByPrimaryKey(pId);
    }

    @Override
    public int modifyByPrimaryKey(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProductInfo> selectAllPro() {
        return productInfoMapper.getAllPro();
    }

    @Override
    public List<ProductInfo> selectProByName(String pName) {
        return productInfoMapper.getProByName(pName);
    }

    @Override
    public int modifyPutAwayByPid(Integer pid, int putAway) {
        return productInfoMapper.updatePutAwayByPid(pid, putAway);
    }
}
