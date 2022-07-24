package com.gcc.advp.system.vo;

import com.gcc.advp.utils.tools.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 用户信息表
*
* @author zhouwenfang.com 
* @since 1.0-SNAPSHOT 2022-07-19
*/
@Data
@Schema(description = "用户信息表")
public class SysUserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "用户 ID")
	private String id;

	@Schema(description = "用户名")
	private String username;

	@Schema(description = "密码，加密存储, admin/1234")
	private String password;

	@Schema(description = "帐户是否过期(1 未过期，0已过期)")
	private Integer isAccountNonExpired;

	@Schema(description = "帐户是否被锁定(1 未过期，0已过期)")
	private Integer isAccountNonLocked;

	@Schema(description = "密码是否过期(1 未过期，0已过期)")
	private Integer isCredentialsNonExpired;

	@Schema(description = "帐户是否可用(1 可用，0 删除用户)")
	private Integer isEnabled;

	@Schema(description = "昵称")
	private String nickName;

	@Schema(description = "头像url")
	private String imageUrl;

	@Schema(description = "注册手机号")
	private String mobile;

	@Schema(description = "注册邮箱")
	private String email;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createDate;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateDate;

	@Schema(description = "密码更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date pwdUpdateDate;


}