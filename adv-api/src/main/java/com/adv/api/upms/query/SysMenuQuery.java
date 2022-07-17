package com.adv.api.upms.query;

import com.adv.util.base.base.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 菜单信息表查询
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "菜单信息表查询")
public class SysMenuQuery extends Query {
}