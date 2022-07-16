package com.adv.api.upms.query;

import com.adv.util.base.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 用户表查询
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-16
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户表查询")
public class SysUserQuery extends Query {
}