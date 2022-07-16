package com.adv.upms.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * mybatis-plus 自动填充字段
 *
 * @author zhouwenfnag
 */
public class FieldMetaObjectHandler implements MetaObjectHandler {
    private final static String CREATE_DATE = "createDate";
    private final static String UPDATE_DATE = "updateDate";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建时间
        strictInsertFill(metaObject, CREATE_DATE, Date.class, new Date());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 修改时间
        strictInsertFill(metaObject, UPDATE_DATE, Date.class, new Date());
    }
}