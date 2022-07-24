package com.gcc.advp.system.service;

import com.gcc.advp.system.entity.SysRoleEntity;
import com.gcc.advp.system.vo.SysRoleVO;
import com.gcc.advp.system.query.SysRoleQuery;
import com.gcc.advp.utils.base.service.BaseService;
import com.gcc.advp.utils.page.PageResult;

import java.util.List;

/**
 * 角色信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

    PageResult<SysRoleVO> page(SysRoleQuery query);

    void save(SysRoleVO vo);

    void update(SysRoleVO vo);

    void delete(List<Long> idList);
}