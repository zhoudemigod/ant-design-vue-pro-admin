package com.gcc.advp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gcc.advp.system.entity.SysUserEntity;
import com.gcc.advp.utils.base.service.impl.BaseServiceImpl;
import com.gcc.advp.utils.page.PageResult;
import lombok.AllArgsConstructor;
import com.gcc.advp.system.convert.SysUserConvert;
import com.gcc.advp.system.query.SysUserQuery;
import com.gcc.advp.system.vo.SysUserVO;
import com.gcc.advp.system.dao.SysUserDao;
import com.gcc.advp.system.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        IPage<SysUserEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private QueryWrapper<SysUserEntity> getWrapper(SysUserQuery query){
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public void save(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public SysUserEntity findByUsername(String username) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }

}