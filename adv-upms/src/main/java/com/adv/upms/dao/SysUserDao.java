package com.adv.upms.dao;

import com.adv.util.base.base.dao.BaseDao;
import com.adv.api.upms.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
* 用户表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-16
*/
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {
	
}