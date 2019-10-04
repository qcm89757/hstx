package com.zjhs.hstx.biz.business.controller;

import com.zjhs.hstx.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


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
@RequestMapping("/business/phone-code")
public class PhoneCodeController {

    @ApiOperation("新增")
    @PostMapping("/add")
    public Result add() {
        return new Result<>();
    }

    @ApiOperation("删除")
    @GetMapping("/del")
    public Result delete() {
        return new Result<>();
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    public Result update() {
        return new Result<>();
    }

    @ApiOperation("详情")
    @GetMapping("/details")
    public Result get() {
        return new Result<>();
    }

    @ApiOperation("列表")
    @GetMapping("/list")
    public Result getList() {
        return new Result<>();
    }

    @ApiOperation("分页列表")
    @PostMapping("/paged")
    public Result getPagedList() {
        return new Result<>();
    }
}

