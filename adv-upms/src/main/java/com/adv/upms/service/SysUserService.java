package com.adv.upms.service;

import com.adv.api.upms.req.RegisterREQ;
import com.adv.api.upms.entity.SysUser;
import com.adv.api.upms.query.SysUserQuery;
import com.adv.api.upms.vo.SysUserVO;
import com.adv.util.base.base.PageResult;
import com.adv.util.base.base.Result;
import com.adv.util.base.base.service.BaseService;

import java.util.List;

/**
 * 用户表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-16
 */
public interface SysUserService extends BaseService<SysUser> {

    PageResult<SysUserVO> page(SysUserQuery query);

    void save(SysUserVO vo);

    void update(SysUserVO vo);

    void delete(List<Long> idList);

    SysUser findByUsername(String username);

    Result checkUsername(String username);

    Result register(RegisterREQ req);
}