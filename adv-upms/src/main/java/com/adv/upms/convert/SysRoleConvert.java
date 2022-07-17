package com.adv.upms.convert;

import com.adv.api.upms.entity.SysRole;
import com.adv.api.upms.vo.SysRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 角色信息表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
*/
@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRole convert(SysRoleVO vo);

    SysRoleVO convert(SysRole entity);

    List<SysRoleVO> convertList(List<SysRole> list);

}