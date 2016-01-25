package com.model.security.menu;

import java.util.Date;

/**
 * MenuInfo entity. @author MyEclipse Persistence Tools
 */

public class MenuInfo implements java.io.Serializable {

	// Fields

	private Integer menuId;
	private String menuName;
	private String menuCode;
	private String menuUrl;
	private Integer menuStatus;
	private Integer menuLevel;
	private Integer parentMenuId;
	private Date createTime;
	private Integer createUserId;
	private String createUserName;
	private Date updateTime;
	private Integer updateUserId;
	private String updateUserName;

	// Constructors

	/** default constructor */
	public MenuInfo() {
	}

	/** full constructor */
	public MenuInfo(String menuName, String menuCode, String menuUrl,
			Integer menuStatus, Integer menuLevel, Integer parentMenuId,
			Date createTime, Integer createUserId, String createUserName,
			Date updateTime, Integer updateUserId, String updateUserName) {
		this.menuName = menuName;
		this.menuCode = menuCode;
		this.menuUrl = menuUrl;
		this.menuStatus = menuStatus;
		this.menuLevel = menuLevel;
		this.parentMenuId = parentMenuId;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCode() {
		return this.menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getMenuStatus() {
		return this.menuStatus;
	}

	public void setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
	}

	public Integer getMenuLevel() {
		return this.menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public Integer getParentMenuId() {
		return this.parentMenuId;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
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