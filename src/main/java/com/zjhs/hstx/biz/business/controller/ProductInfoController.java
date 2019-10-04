package com.zjhs.hstx.biz.business.controller;

import com.zjhs.hstx.base.Result;
import com.zjhs.hstx.biz.business.bean.ProductInfo;
import com.zjhs.hstx.biz.business.service.IProductInfoService;
import com.zjhs.hstx.exception.CheckException;
import com.zjhs.hstx.exception.OperationFailedException;
import com.zjhs.hstx.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Api("控制器")
@RestController
@RequestMapping("/business/product-info")
public class ProductInfoController {

    @Value("${web.upload-path}")
    private String filePath;

    private final IProductInfoService productInfoService;

    @Autowired
    public ProductInfoController(IProductInfoService productInfoService) {
        this.productInfoService = productInfoService;
    }

    /**
     * 添加商品信息
     */
    @ApiOperation("添加商品信息")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Result addProduct(@ApiParam(name = "file", value = "文件") @RequestParam(name = "file") MultipartFile file,
                             @ApiParam(name = "tId", value = "类型id") @RequestParam(name = "tId") Integer tId,
                             @ApiParam(name = "pName", value = "产品名称") @RequestParam(name = "pName")  String pName,
                             @ApiParam(name = "pMoney", value = "产品价格") @RequestParam(name = "pMoney")  BigDecimal pMoney,
                             @ApiParam(name = "pDepict", value = "产品描述") @RequestParam(name = "pDepict")  String pDepict,
                             @ApiParam(name = "pNum", value = "产品份量") @RequestParam(name = "pNum")  Integer pNum) {
        if(file.isEmpty()) {
            throw new CheckException("请选择图片");
        }
        //1定义要上传文件 的存放路径
        String localPath=filePath;
        //2获得文件名字
        String fileName=file.getOriginalFilename();
        //2上传失败提示
        String newFileName = FileUtils.getFileName(fileName);
        if(FileUtils.upload(file, localPath, newFileName)){
            //查询此id是否有图片
            ProductInfo product = new ProductInfo();
            product.setTId(tId);
            product.setPImg(newFileName);
            product.setPName(pName);
            product.setPMoney(pMoney);
            product.setPDepict(pDepict);
            product.setPNum(pNum);
            if (productInfoService.insert(product)) {
                return Result.success("插入成功！");
            }else {
                return Result.success("插入失败！");
            }
        } else {
            throw new OperationFailedException("上传失败！");
        }
    }

    /**
     * 根据pid查询商品信息
     */
    @ApiOperation("根据pid查询商品信息")
    @RequestMapping(value = "/getInfoByid", method = RequestMethod.GET)
    @ResponseBody
    public Result getInfoByid(@ApiParam(name = "pId", value = "产品id")
                                  @RequestParam(name = "pId") Integer pId){
        if(pId==null) {
            throw new CheckException("请输入你要查询商品的id！");
        }else {
            ProductInfo data = productInfoService.getInfoByPid(pId);
            if (data != null) {
                return Result.success(data);
            } else {
                return Result.fail("400","插入失败！");
            }
        }
    }

    /**
     * 删除指定产品
     */
    @ApiOperation("删除指定产品")
    @RequestMapping(value="/removeProByid",method=RequestMethod.DELETE)
    @ResponseBody
    public Result removeProByid(@ApiParam(name = "pId", value = "产品id")
                                    @RequestParam(name = "pId") Integer pId) {
        int n = productInfoService.removeByPrimaryKey(pId);
        if (n > 0) {
            return Result.success("删除成功！");
        } else {
            return Result.fail("500","删除失败！");
        }
    }

    /**
     * 修改商品信息
     */
    @ApiOperation("修改商品信息")
    @RequestMapping(value="/updateProByid",method=RequestMethod.POST)
    @ResponseBody
    public Result modifyProByid(@ApiParam(name = "file", value = "文件") @RequestParam(name = "file") MultipartFile file,
                                @ApiParam(name = "pId", value = "id") @RequestParam(name = "pId") Integer pId,
                                @ApiParam(name = "tId", value = "类型id") @RequestParam(name = "tId") Integer tId,
                                @ApiParam(name = "pName", value = "产品名称") @RequestParam(name = "pName")  String pName,
                                @ApiParam(name = "pMoney", value = "产品价格") @RequestParam(name = "pMoney")  BigDecimal pMoney,
                                @ApiParam(name = "pDepict", value = "产品描述") @RequestParam(name = "pDepict")  String pDepict,
                                @ApiParam(name = "pNum", value = "产品份量") @RequestParam(name = "pNum")  Integer pNum) {
        if(file.isEmpty()) {
            throw new CheckException("请选择图片");
        }else {
            //1定义要上传文件 的存放路径
            String localPath=filePath;
            //2获得文件名字
            String fileName=file.getOriginalFilename();
            //2上传失败提示
            String newFileName = FileUtils.getFileName(fileName);
            if(FileUtils.upload(file, localPath, newFileName)){

                //查询此id是否有图片
                ProductInfo record = new ProductInfo();
                record.setPId(pId);
                record.setTId(tId);
                record.setPImg(newFileName);
                record.setPName(pName);
                record.setPMoney(pMoney);
                record.setPDepict(pDepict);
                record.setPNum(pNum);
                /*
                 * 传入的对象，set到pro中
                 */
                int n = productInfoService.modifyByPrimaryKey(record);
                if (n > 0) {
                    return Result.success("修改成功！");
                } else {
                    return  Result.fail("400","修改失败!");
                }
            } else {
                throw new OperationFailedException("文件上传失败");
            }
        }
    }

    /**
     * 查询所有商品信息
     */
    @ApiOperation("查询所有商品信息")
    @RequestMapping(value="/getAllPro",method=RequestMethod.GET)
    @ResponseBody
    public Result getAllPro() {
        List<ProductInfo> allPro = productInfoService.selectAllPro();
        if(allPro.isEmpty()) {
            return Result.fail("404","没有商品");
        }else {
            return Result.success("查询成功！");
        }
    }


    /**
     * 模糊查询
     */
    @ApiOperation("模糊查询")
    @RequestMapping(value="/selectProByName",method=RequestMethod.GET)
    @ResponseBody
    public Result selectProByName(@ApiParam(name = "pName", value = "产品名称")
                                      @RequestParam(name = "pName") String pName) {
        if(StringUtils.isEmpty(pName)) {
            throw new CheckException("请输入查询信息！");
        }else {
            List<ProductInfo> list = productInfoService.selectProByName(pName);
            return Result.success(list);
        }
    }


    @ApiOperation("上下架")
    @RequestMapping(value="/updatePutAway",method= RequestMethod.POST)
    @ResponseBody
    public Result updatePutAway(@ApiParam(name = "p_id", value = "产品id")
                                    @RequestParam Integer p_id,
                                @ApiParam(name = "isTrue", value = "上下架标识")
                                    @RequestParam Boolean isTrue) {
        if(isTrue==null) {
            throw new CheckException("请选择上下架");
        }
        if(isTrue) {
            //1表示上架，0表示下架
            int n = productInfoService.modifyPutAwayByPid(p_id, 1);
            if(n>0) {
                return Result.success("上架成功！");
            }
        } else {
            int n = productInfoService.modifyPutAwayByPid(p_id, 0);
            if(n>0) {
                return Result.success("下架成功！");
            }
        }
        return Result.fail("操作失败！");
    }
}

