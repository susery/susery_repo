package com.model.relationship;

import java.util.Date;

/**
 * RoleAuthorityR entity. @author MyEclipse Persistence Tools
 */

public class RoleAuthorityR implements java.io.Serializable {

	// Fields

	private Integer roleAuthorityRId;
	private Integer roleId;
	private Integer authorityId;
	private Integer status;
	private Date createTime;
	private Integer createUserId;
	private String createUserName;
	private Date updateTime;
	private Integer updateUserId;
	private String updateUserName;

	// Constructors

	/** default constructor */
	public RoleAuthorityR() {
	}

	/** full constructor */
	public RoleAuthorityR(Integer roleId, Integer authorityId, Integer status,
			Date createTime, Integer createUserId, String createUserName,
			Date updateTime, Integer updateUserId, String updateUserName) {
		this.roleId = roleId;
		this.authorityId = authorityId;
		this.status = status;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
	}

	// Property accessors

	public Integer getRoleAuthorityRId() {
		return this.roleAuthorityRId;
	}

	public void setRoleAuthorityRId(Integer roleAuthorityRId) {
		this.roleAuthorityRId = roleAuthorityRId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
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