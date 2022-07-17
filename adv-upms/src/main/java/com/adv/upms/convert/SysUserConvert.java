package com.adv.upms.convert;

import com.adv.api.upms.vo.SysUserVO;
import com.adv.api.upms.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
* 用户表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-16
*/
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUser convert(SysUserVO vo);

    SysUserVO convert(SysUser entity);

    List<SysUserVO> convertList(List<SysUser> list);

}