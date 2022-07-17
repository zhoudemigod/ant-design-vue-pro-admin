package com.adv.upms.service;

import com.adv.api.upms.vo.SysRoleVO;
import com.adv.api.upms.entity.SysRole;
import com.adv.api.upms.query.SysRoleQuery;
import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.service.BaseService;
import java.util.List;

/**
 * 角色信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-17
 */
public interface SysRoleService extends BaseService<SysRole> {

    PageResult<SysRoleVO> page(SysRoleQuery query);

    void save(SysRoleVO vo);

    void update(SysRoleVO vo);

    void delete(List<Long> idList);
}