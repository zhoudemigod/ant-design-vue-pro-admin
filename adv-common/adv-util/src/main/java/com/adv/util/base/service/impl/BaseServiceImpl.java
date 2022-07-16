package com.adv.util.base.service.impl;

import com.adv.util.base.Query;
import com.adv.util.base.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


/**
 * 基础服务类，所有Service都要继承
 *
 * @author zhouwenfnag
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T>  extends ServiceImpl<M, T> implements BaseService<T> {

    /**
     * 获取分页对象
     * @param query   分页参数
     */
    protected IPage<T> getPage(Query query) {
        Page<T> page = new Page<>(query.getPage(), query.getLimit());
        page.addOrder(OrderItem.desc("id"));
        return page;
    }

    protected QueryWrapper<T> getWrapper(Query query){
        QueryWrapper<T> wrapper = new QueryWrapper<>();
//        wrapper.like(StrUtil.isNotEmpty(query.getCode()), "code", query.getCode());
        return wrapper;
    }

}