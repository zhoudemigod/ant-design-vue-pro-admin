package com.adv.upms.dao;

import com.adv.api.upms.entity.SysRole;
import com.adv.util.base.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
* 角色信息表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
*/
@Mapper
public interface SysRoleDao extends BaseDao<SysRole> {
	
}