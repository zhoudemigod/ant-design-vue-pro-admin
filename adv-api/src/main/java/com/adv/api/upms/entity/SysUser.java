package com.adv.api.upms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Value;

import java.util.Date;

/**
 * 用户表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-16
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user")
public class SysUser {
	/**
	* 主键uuid
	*/
	@TableId(value = "id", type = IdType.ASSIGN_UUID)
	private String id;

	/**
	* 别名
	*/
	private String name;

	/**
	* 用户名
	*/
	private String username;

	/**
	* 密码
	*/
	private String password;

	/**
	* 头像
	*/
	private String avatar;

	/**
	* 状态
	*/
	private Integer status;

	/**
	* 手机号
	*/
	private Integer telephone;

	/**
	* 最后登录ip
	*/
	private String lastLoginIp;

	/**
	* 最后登录时间
	*/
	private Date lastLoginTime;

	/**
	* 创建人id
	*/
	private String creatorId;

	/**
	* 创建时间
	*/
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	* 商户号
	*/
	private String merchantCode;

	/**
	* 是否删除
	*/
	@TableLogic
	@TableField(fill = FieldFill.INSERT)
	private Integer deleted;

}