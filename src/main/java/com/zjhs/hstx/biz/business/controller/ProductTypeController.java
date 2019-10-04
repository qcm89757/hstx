package com.zjhs.hstx.biz.business.controller;

import com.zjhs.hstx.base.Result;
import com.zjhs.hstx.biz.business.bean.ProductInfo;
import com.zjhs.hstx.biz.business.bean.ProductType;
import com.zjhs.hstx.biz.business.dao.ProductTypeMapper;
import com.zjhs.hstx.exception.CheckException;
import com.zjhs.hstx.exception.OperationFailedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Api("控制器")
@RestController
@RequestMapping("/business/product-type")
public class ProductTypeController {

    private final ProductTypeMapper productTypeMapper;

    @Autowired
    public ProductTypeController(ProductTypeMapper productTypeMapper) {
        this.productTypeMapper = productTypeMapper;
    }


    /**
     * 添加商品类型
     */
    @ApiOperation("添加商品类型")
    @RequestMapping(value = "/addProType", method = RequestMethod.POST)
    @ResponseBody
    public Result addProType(@ApiParam(name = "t_name", value = "类型名")
                                 @RequestParam(name = "t_name") String t_name) {
        ProductType productType = new ProductType();
        productType.setTName(t_name);

        if (productTypeMapper.insert(productType) > 0) {
            return Result.success("添加成功");
        } else {
            throw new OperationFailedException("添加失败");
        }
    }

    /**
     * 通过id修改
     */
    @ApiOperation("通过id修改")
    @RequestMapping(value = "/modifiProType", method = RequestMethod.POST)
    @ResponseBody
    public Result modifiProType(@ApiParam(name = "t_id", value = "类型id")
                                    @RequestParam Integer t_id,
                                @ApiParam(name = "t_name", value = "类型名")
                                    @RequestParam String t_name) {
        ProductType productType = new ProductType();
        productType.setTId(t_id);
        productType.setTName(t_name);
        int n = productTypeMapper.updateType(productType);
        if (n > 0) {
            return Result.success("修改成功", null);
        } else {
            throw new OperationFailedException("操作失败！");
        }
    }

    /**
     * 查询所有商品
     */
    @ApiOperation("查询所有商品")
    @RequestMapping(value = "/selectAllCreate", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<ProductType>> selectAllCreate() {
        List<ProductType> list = productTypeMapper.getAllCrate();
        return Result.success(list);
    }

    /**
     * 查询某个类型下的所有菜品
     */
    @ApiOperation("查询某个类型下的所有菜品")
    @RequestMapping(value = "/selectInfoByCrateId", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<ProductInfo>> selectInfoByCrateId(@ApiParam(name = "t_id", value = "类型id")
                                          @RequestParam Integer tId) {
        List<ProductInfo> list = productTypeMapper.getInfoByCrateId(tId);
        return Result.success(list);
    }

    /**
     * delete商品类型
     */
    @ApiOperation("delete商品类型")
    @RequestMapping(value = "/deleteProById", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteProById(@ApiParam(name = "t_id", value = "类型id")
                                    @RequestParam Integer tId) {
        List<ProductInfo> lis = productTypeMapper.getInfoByCrateId(tId);
        if (lis.isEmpty()) {
            int n = productTypeMapper.removeType(tId);
            if (n > 0) {
                return Result.success("删除成功！",null);
            } else {
                return Result.fail("500","删除失败！");
            }
        } else {
            throw new CheckException("该类型下依然有商品，请先删除该类下的商品！");
        }
    }

}

