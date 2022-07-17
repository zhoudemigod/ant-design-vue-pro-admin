package com.adv.upms.convert;

import com.adv.api.upms.vo.SysMenuVO;
import com.adv.api.upms.entity.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 菜单信息表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
*/
@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenu convert(SysMenuVO vo);

    SysMenuVO convert(SysMenu entity);

    List<SysMenuVO> convertList(List<SysMenu> list);

}