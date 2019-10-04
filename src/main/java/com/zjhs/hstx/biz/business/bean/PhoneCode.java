package com.zjhs.hstx.biz.business.bean;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mybatisPlusTool
 * @since 2019-10-03
 */
@Data
@Accessors(chain = true)
@TableName("phone_code")
public class PhoneCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userPhone;
    private String code;
    private Date createtime;



}
