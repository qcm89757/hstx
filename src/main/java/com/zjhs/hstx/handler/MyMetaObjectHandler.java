package com.zjhs.hstx.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.zjhs.hstx.base.CommonConstants;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * mybatis 自动填充处理器
 *
 * @author qiancm
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //  创建时间
        if (checkParam(metaObject, "createTime")) {
            this.setFieldValByName("createTime", new Date(), metaObject);
        }

        // 逻辑删除
        this.setFieldValByName("delTf", CommonConstants.DELETE_CODE.DEL_FLAG_NORMAL, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 修改时间
        if (checkParam(metaObject, "updateTime")) {
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
    }

    /**
     * 校验字段
     * 存在该字段，并且该字段未赋值
     */
    private boolean checkParam(MetaObject metaObject, String fieldName) {
        return
                (
                        metaObject.hasGetter(fieldName) &&
                                StringUtils.isEmpty(metaObject.getValue(fieldName))
                ) ||
                        (
                                metaObject.hasGetter(META_OBJ_PREFIX + "." + fieldName) &&
                                        StringUtils.isEmpty(metaObject.getValue(META_OBJ_PREFIX + "." + fieldName))
                        );
    }

}
