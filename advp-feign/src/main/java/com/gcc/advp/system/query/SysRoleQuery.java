package com.gcc.advp.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.gcc.advp.utils.page.Query;

import java.util.Date;

/**
* 角色信息表查询
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色信息表查询")
public class SysRoleQuery extends Query {
}