package com.gcc.advp.system.dao;

import com.gcc.advp.system.entity.SysRoleEntity;
import com.gcc.advp.utils.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
* 角色信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
	
}