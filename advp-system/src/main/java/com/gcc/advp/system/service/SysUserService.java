package com.gcc.advp.system.service;

import com.gcc.advp.system.entity.SysUserEntity;
import com.gcc.advp.system.vo.SysUserVO;
import com.gcc.advp.system.query.SysUserQuery;
import com.gcc.advp.utils.base.service.BaseService;
import com.gcc.advp.utils.page.PageResult;


import java.util.List;

/**
 * 用户信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    PageResult<SysUserVO> page(SysUserQuery query);

    void save(SysUserVO vo);

    void update(SysUserVO vo);

    void delete(List<Long> idList);

    SysUserEntity findByUsername(String username);
}