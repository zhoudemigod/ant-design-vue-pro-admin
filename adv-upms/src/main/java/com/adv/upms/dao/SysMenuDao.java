package com.adv.upms.dao;

import com.adv.api.upms.entity.SysMenu;
import com.adv.util.base.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 菜单信息表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
*/
@Mapper
public interface SysMenuDao extends BaseDao<SysMenu> {

    /**
     * 查询指定用户id所拥有的菜单权限（目录、菜单、按钮）
     * @param userId
     * @return
     */
    List<SysMenu> findByUserId(@Param("userId") String userId);
}