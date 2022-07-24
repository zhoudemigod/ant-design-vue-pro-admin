package com.gcc.advp.system.convert;

import com.gcc.advp.system.entity.SysRoleEntity;
import com.gcc.advp.system.vo.SysRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 角色信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleEntity convert(SysRoleVO vo);

    SysRoleVO convert(SysRoleEntity entity);

    List<SysRoleVO> convertList(List<SysRoleEntity> list);

}