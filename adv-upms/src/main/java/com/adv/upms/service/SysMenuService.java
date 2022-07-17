package com.adv.upms.service;

import com.adv.api.upms.vo.SysMenuVO;
import com.adv.api.upms.entity.SysMenu;
import com.adv.api.upms.query.SysMenuQuery;
import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.service.BaseService;

import java.util.List;

/**
 * 菜单信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-17
 */
public interface SysMenuService extends BaseService<SysMenu> {

    PageResult<SysMenuVO> page(SysMenuQuery query);

    void save(SysMenuVO vo);

    void update(SysMenuVO vo);

    void delete(List<Long> idList);

    List<SysMenu> findByUserId(String userId);
}