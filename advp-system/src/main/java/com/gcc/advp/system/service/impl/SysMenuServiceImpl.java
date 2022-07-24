package com.gcc.advp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gcc.advp.system.entity.SysMenuEntity;
import com.gcc.advp.utils.base.service.impl.BaseServiceImpl;
import com.gcc.advp.utils.page.PageResult;
import lombok.AllArgsConstructor;
import com.gcc.advp.system.convert.SysMenuConvert;
import com.gcc.advp.system.query.SysMenuQuery;
import com.gcc.advp.system.vo.SysMenuVO;
import com.gcc.advp.system.dao.SysMenuDao;
import com.gcc.advp.system.service.SysMenuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单信息表
 *
 * @author zhouwenfang 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public PageResult<SysMenuVO> page(SysMenuQuery query) {
        IPage<SysMenuEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysMenuConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private QueryWrapper<SysMenuEntity> getWrapper(SysMenuQuery query){
        QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public void save(SysMenuVO vo) {
        SysMenuEntity entity = SysMenuConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysMenuVO vo) {
        SysMenuEntity entity = SysMenuConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public List<SysMenuEntity> findByUserId(String userId) {
        // 通过用户id查询权限信息
        List<SysMenuEntity> menuList = baseMapper.findByUserId(userId);
        if( CollectionUtils.isEmpty(menuList)
                || menuList.get(0) == null ) {
            return null;
        }
        return menuList;
    }

}