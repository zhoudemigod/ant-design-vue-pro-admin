package com.adv.upms.service.impl;


import com.adv.api.upms.entity.SysUser;
import com.adv.api.upms.query.SysUserQuery;
import com.adv.api.upms.vo.SysUserVO;
import com.adv.upms.convert.SysUserConvert;
import com.adv.upms.dao.SysUserDao;
import com.adv.upms.service.SysUserService;
import com.adv.util.base.PageResult;
import com.adv.util.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-16
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        IPage<SysUser> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private QueryWrapper<SysUser> getWrapper(SysUserQuery query){
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public void save(SysUserVO vo) {
        SysUser entity = SysUserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysUserVO vo) {
        SysUser entity = SysUserConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}