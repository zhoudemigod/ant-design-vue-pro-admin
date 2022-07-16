package com.adv.api.upms.vo;

import com.adv.util.tools.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 用户表
*
* @author zhouwenfang.com 
* @since 1.0.0 2022-07-16
*/
@Data
@Schema(description = "用户表")
public class SysUserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键uuid")
	private String id;

	@Schema(description = "别名")
	private String name;

	@Schema(description = "用户名")
	private String username;

	@Schema(description = "密码")
	private String password;

	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "状态")
	private Integer status;

	@Schema(description = "手机号")
	private Integer telephone;

	@Schema(description = "最后登录ip")
	private String lastLoginIp;

	@Schema(description = "最后登录时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date lastLoginTime;

	@Schema(description = "创建人id")
	private String creatorId;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "商户号")
	private String merchantCode;

	@Schema(description = "是否删除")
	private Integer deleted;


}