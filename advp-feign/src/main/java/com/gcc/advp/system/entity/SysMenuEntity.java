package com.gcc.advp.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 菜单信息表
 *
 * @author zhouwenfang 
 * @since 1.0-SNAPSHOT 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_menu")
public class SysMenuEntity {
	/**
	* 菜单 ID
	*/
	@TableId
	private String id;

	/**
	* 父菜单 ID (0为顶级菜单)
	*/
	private String parentId;

	/**
	* 菜单名称
	*/
	private String name;

	/**
	* 请求地址
	*/
	private String url;

	/**
	* 类型(1目录，2菜单，3按钮)
	*/
	private Integer type;

	/**
	* 授权标识符
	*/
	private String code;

	/**
	* 图标
	*/
	private String icon;

	/**
	* 排序
	*/
	private Integer sort;

	/**
	* 备注
	*/
	private String remark;

	/**
	* 创建时间
	*/
	private Date createDate;

	/**
	* 更新时间
	*/
	private Date updateDate;

}