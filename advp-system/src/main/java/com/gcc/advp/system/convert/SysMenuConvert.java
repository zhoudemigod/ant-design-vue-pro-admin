package com.gcc.advp.system.convert;

import com.gcc.advp.system.entity.SysMenuEntity;
import com.gcc.advp.system.vo.SysMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 菜单信息表
*
* @author zhouwenfang 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenuEntity convert(SysMenuVO vo);

    SysMenuVO convert(SysMenuEntity entity);

    List<SysMenuVO> convertList(List<SysMenuEntity> list);

}