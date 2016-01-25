package com.model.relationship;

import java.util.Date;

/**
 * RoleMenuR entity. @author MyEclipse Persistence Tools
 */

public class RoleMenuR implements java.io.Serializable {

	// Fields

	private Integer roleMenuRId;
	private Integer roleId;
	private Integer menuId;
	private Integer status;
	private Date createTime;
	private Integer createUserId;
	private String createUserName;
	private Date updateTime;
	private Integer updateUserId;
	private String updateUserName;

	// Constructors

	/** default constructor */
	public RoleMenuR() {
	}

	/** full constructor */
	public RoleMenuR(Integer roleId, Integer menuId, Integer status,
			Date createTime, Integer createUserId, String createUserName,
			Date updateTime, Integer updateUserId, String updateUserName) {
		this.roleId = roleId;
		this.menuId = menuId;
		this.status = status;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
	}

	// Property accessors

	public Integer getRoleMenuRId() {
		return this.roleMenuRId;
	}

	public void setRoleMenuRId(Integer roleMenuRId) {
		this.roleMenuRId = roleMenuRId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

}