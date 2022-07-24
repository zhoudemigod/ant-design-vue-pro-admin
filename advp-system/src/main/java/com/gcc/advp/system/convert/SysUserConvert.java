package com.gcc.advp.system.convert;

import com.gcc.advp.system.entity.SysUserEntity;
import com.gcc.advp.system.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 用户信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserEntity convert(SysUserVO vo);

    SysUserVO convert(SysUserEntity entity);

    List<SysUserVO> convertList(List<SysUserEntity> list);

}