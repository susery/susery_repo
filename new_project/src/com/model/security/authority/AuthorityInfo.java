package com.model.security.authority;

import java.util.Date;

/**
 * AuthorityInfo entity. @author MyEclipse Persistence Tools
 */

public class AuthorityInfo implements java.io.Serializable {

	// Fields

	private Integer authorityId;
	private String authorityName;
	private String authorityCode;
	private Integer authorityStatus;
	private Date createTime;
	private Integer createUserId;
	private String createUserName;
	private Date updateTime;
	private Integer updateUserId;
	private String updateUserName;

	// Constructors

	/** default constructor */
	public AuthorityInfo() {
	}

	/** full constructor */
	public AuthorityInfo(String authorityName, String authorityCode,
			Integer authorityStatus, Date createTime, Integer createUserId,
			String createUserName, Date updateTime, Integer updateUserId,
			String updateUserName) {
		this.authorityName = authorityName;
		this.authorityCode = authorityCode;
		this.authorityStatus = authorityStatus;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
	}

	// Property accessors

	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityCode() {
		return this.authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	public Integer getAuthorityStatus() {
		return this.authorityStatus;
	}

	public void setAuthorityStatus(Integer authorityStatus) {
		this.authorityStatus = authorityStatus;
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