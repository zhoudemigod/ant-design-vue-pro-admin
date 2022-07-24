package com.gcc.advp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gcc.advp.system.entity.SysRoleEntity;
import com.gcc.advp.utils.base.service.impl.BaseServiceImpl;
import com.gcc.advp.utils.page.PageResult;
import lombok.AllArgsConstructor;
import com.gcc.advp.system.convert.SysRoleConvert;
import com.gcc.advp.system.query.SysRoleQuery;
import com.gcc.advp.system.vo.SysRoleVO;
import com.gcc.advp.system.dao.SysRoleDao;
import com.gcc.advp.system.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Override
    public PageResult<SysRoleVO> page(SysRoleQuery query) {
        IPage<SysRoleEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysRoleConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private QueryWrapper<SysRoleEntity> getWrapper(SysRoleQuery query){
        QueryWrapper<SysRoleEntity> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public void save(SysRoleVO vo) {
        SysRoleEntity entity = SysRoleConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysRoleVO vo) {
        SysRoleEntity entity = SysRoleConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}