package com.gcc.advp.system.dao;

import com.gcc.advp.system.entity.SysUserEntity;
import com.gcc.advp.utils.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
* 用户信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
	
}