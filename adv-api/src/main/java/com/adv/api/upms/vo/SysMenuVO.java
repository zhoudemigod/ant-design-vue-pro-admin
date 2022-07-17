package com.adv.api.upms.vo;

import com.adv.util.base.tools.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 菜单信息表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-17
*/
@Data
@Schema(description = "菜单信息表")
public class SysMenuVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "菜单 ID")
	private String id;

	@Schema(description = "父菜单 ID (0为顶级菜单)")
	private String parentId;

	@Schema(description = "菜单名称")
	private String name;

	@Schema(description = "请求地址")
	private String url;

	@Schema(description = "类型(1目录，2菜单，3按钮)")
	private Integer type;

	@Schema(description = "授权标识符")
	private String code;

	@Schema(description = "图标")
	private String icon;

	@Schema(description = "排序")
	private Integer sort;

	@Schema(description = "备注")
	private String remark;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createDate;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateDate;


}