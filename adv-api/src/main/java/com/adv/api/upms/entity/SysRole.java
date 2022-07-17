package com.adv.api.upms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 角色信息表
 *
 * @author zhouwenfang.com 
 * @since 1.0.0 2022-07-17
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRole {
	/**
	* 角色 ID
	*/
	@TableId
	private String id;

	/**
	* 角色名称
	*/
	private String name;

	/**
	* 角色说明
	*/
	private String remark;

	private Date createDate;

	private Date updateDate;

}