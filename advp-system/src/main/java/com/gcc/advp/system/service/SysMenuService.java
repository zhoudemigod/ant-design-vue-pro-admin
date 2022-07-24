package com.gcc.advp.system.service;

import com.gcc.advp.system.entity.SysMenuEntity;
import com.gcc.advp.system.vo.SysMenuVO;
import com.gcc.advp.system.query.SysMenuQuery;
import com.gcc.advp.utils.base.service.BaseService;
import com.gcc.advp.utils.page.PageResult;

import java.util.List;

/**
 * 菜单信息表
 *
 * @author zhouwenfang 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

    PageResult<SysMenuVO> page(SysMenuQuery query);

    void save(SysMenuVO vo);

    void update(SysMenuVO vo);

    void delete(List<Long> idList);

    List<SysMenuEntity> findByUserId(String userId);
}