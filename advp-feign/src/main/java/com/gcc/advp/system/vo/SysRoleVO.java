package com.gcc.advp.system.vo;

import com.gcc.advp.utils.tools.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 角色信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Data
@Schema(description = "角色信息表")
public class SysRoleVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "角色 ID")
	private String id;

	@Schema(description = "角色名称")
	private String name;

	@Schema(description = "角色说明")
	private String remark;

	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createDate;

	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateDate;


}