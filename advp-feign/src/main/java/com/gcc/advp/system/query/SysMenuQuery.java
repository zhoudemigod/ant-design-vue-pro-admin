package com.gcc.advp.system.query;

import com.gcc.advp.utils.page.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
* 菜单信息表查询
*
* @author zhouwenfang 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "菜单信息表查询")
public class SysMenuQuery extends Query {
}