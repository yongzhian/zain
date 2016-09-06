package com.flwrobot.entity;

import java.util.Date;

/**
 * Created by Zain 2016/9/6 .
 */
public class SysRole {
	private Long id;
	private String roleCode; //role_code
	private String roleName; //role_name

	private String isValid; //is_valid
	private Date createTime; //create_time

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
