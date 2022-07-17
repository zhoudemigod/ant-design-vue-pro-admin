package com.adv.upms.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.adv.api.upms.vo.SysMenuVO;
import com.adv.api.upms.entity.SysMenu;
import com.adv.api.upms.query.SysMenuQuery;
import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.service.impl.BaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.adv.upms.convert.SysMenuConvert;
import com.adv.upms.dao.SysMenuDao;
import com.adv.upms.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-17
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Override
    public PageResult<SysMenuVO> page(SysMenuQuery query) {
        IPage<SysMenu> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysMenuConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private QueryWrapper<SysMenu> getWrapper(SysMenuQuery query){
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();

        return wrapper;
    }

    @Override
    public void save(SysMenuVO vo) {
        SysMenu entity = SysMenuConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysMenuVO vo) {
        SysMenu entity = SysMenuConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public List<SysMenu> findByUserId(String userId) {
        // 通过用户id查询权限信息
        List<SysMenu> menuList = baseMapper.findByUserId(userId);
        if( ArrayUtil.isEmpty(menuList)
                || menuList.get(0) == null ) {
            return null;
        }
        return menuList;
    }

}