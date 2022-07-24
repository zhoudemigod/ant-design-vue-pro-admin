package com.gcc.advp.system.dao;

import com.gcc.advp.system.entity.SysMenuEntity;
import com.gcc.advp.utils.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 菜单信息表
*
* @author zhouwenfang 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

    List<SysMenuEntity> findByUserId(@Param("userId") String userId);
}