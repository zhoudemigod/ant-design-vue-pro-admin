package com.adv.upms.service.impl;

import com.adv.api.upms.vo.SysRoleVO;
import com.adv.api.upms.entity.SysRole;
import com.adv.api.upms.query.SysRoleQuery;
import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.adv.upms.convert.SysRoleConvert;
import com.adv.upms.dao.SysRoleDao;
import com.adv.upms.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-17
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Override
    public PageResult<SysRoleVO> page(SysRoleQuery query) {
        IPage<SysRole> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysRoleConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private QueryWrapper<SysRole> getWrapper(SysRoleQuery query){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public void save(SysRoleVO vo) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysRoleVO vo) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}