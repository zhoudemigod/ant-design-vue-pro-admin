package com.gcc.advp.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 用户信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user")
public class SysUserEntity {
	/**
	* 用户 ID
	*/
	@TableId
	private String id;

	/**
	* 用户名
	*/
	private String username;

	/**
	* 密码，加密存储, admin/1234
	*/
	private String password;

	/**
	* 帐户是否过期(1 未过期，0已过期)
	*/
	private Integer isAccountNonExpired;

	/**
	* 帐户是否被锁定(1 未过期，0已过期)
	*/
	private Integer isAccountNonLocked;

	/**
	* 密码是否过期(1 未过期，0已过期)
	*/
	private Integer isCredentialsNonExpired;

	/**
	* 帐户是否可用(1 可用，0 删除用户)
	*/
	private Integer isEnabled;

	/**
	* 昵称
	*/
	private String nickName;

	/**
	* 头像url
	*/
	private String imageUrl;

	/**
	* 注册手机号
	*/
	private String mobile;

	/**
	* 注册邮箱
	*/
	private String email;

	/**
	* 创建时间
	*/
	private Date createDate;

	/**
	* 更新时间
	*/
	private Date updateDate;

	/**
	* 密码更新时间
	*/
	private Date pwdUpdateDate;

}