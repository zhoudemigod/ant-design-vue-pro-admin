package com.adv.upms.dao;

import com.adv.api.upms.entity.SysUser;
import com.adv.util.base.dao.BaseDao;
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