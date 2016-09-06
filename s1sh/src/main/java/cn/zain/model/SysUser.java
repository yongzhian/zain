package com.flwrobot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.flwrobot.util.MD5Util;
import com.flwrobot.util.StringTools;

/**
 * Created by Zain 2016/9/6 .
 */
public class SysUser implements Serializable {

	private long id;
	private String username;  
	private String password; // password
	private String fullName; // full_name
	private String email; // email
	private String isValid; // is_valid
	
	private Date createTime; // create_time
	
	private Date lastLogin; // last_login
	
	private String lastLoginIp; // last_login_ip

	
	public SysUser() {
		
	}
	
	public SysUser(HttpServletRequest request) {
		String _username = request.getParameter("username");
		String _password = request.getParameter("password");
		
		if(StringUtils.isBlank(_username) || StringUtils.isBlank(_password)) {
			throw new IllegalArgumentException("用户名或密码为空。 username: " + _username + ", password: " + _password);
		}
		
		this.username = _username.trim();
		
		this.password = MD5Util.md5(_password.trim());
		
		this.fullName = StringTools.nvl(request.getParameter("full_name"));
		this.email = StringTools.nvl(request.getParameter("email"));
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SysUser [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", lastLogin=");
		builder.append(lastLogin);
		builder.append(", lastLoginIp=");
		builder.append(lastLoginIp);
		builder.append("]");
		return builder.toString();
	}

}
