/**
 * UserBean.java V1.0 2014-9-23 下午9:42:32 
 * Copyright reapfruit Co. ,Ltd. All rights reserved.  
 * Author: yongzhian
 * Description:
 */

package cn.zain.model;

public class User {
	private Integer id;
	private String userName;
	private String className;
	private String gender;
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", className='" + className + '\'' +
				", gender='" + gender + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
