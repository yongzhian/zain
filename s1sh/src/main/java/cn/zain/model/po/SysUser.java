package cn.zain.model.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Entity
@Table(name = "sys_user", schema = "luman", catalog = "")
public class SysUser {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String isValid;
    private String createTime;
    private Timestamp lastLogin;
    private String lastLoginIp;
    private Set<SysRole> roles;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "is_valid", nullable = false, length = 1)
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    @Basic
    @Column(name = "create_time", nullable = false, length = 50)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_login", nullable = true)
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "last_login_ip", nullable = true, length = 50)
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUser sysUser = (SysUser) o;

        if (id != null ? !id.equals(sysUser.id) : sysUser.id != null) return false;
        if (username != null ? !username.equals(sysUser.username) : sysUser.username != null) return false;
        if (password != null ? !password.equals(sysUser.password) : sysUser.password != null) return false;
        if (fullName != null ? !fullName.equals(sysUser.fullName) : sysUser.fullName != null) return false;
        if (email != null ? !email.equals(sysUser.email) : sysUser.email != null) return false;
        if (isValid != null ? !isValid.equals(sysUser.isValid) : sysUser.isValid != null) return false;
        if (createTime != null ? !createTime.equals(sysUser.createTime) : sysUser.createTime != null) return false;
        if (lastLogin != null ? !lastLogin.equals(sysUser.lastLogin) : sysUser.lastLogin != null) return false;
        if (lastLoginIp != null ? !lastLoginIp.equals(sysUser.lastLoginIp) : sysUser.lastLoginIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        return result;
    }

    @ManyToMany
    @JoinTable(name = "sys_user_role", catalog = "", schema = "luman", joinColumns = @JoinColumn(name = "sys_user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sys_role_id", referencedColumnName = "id"))
    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", isValid='" + isValid + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastLogin=" + lastLogin +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", roles=" + (roles == null ? "null" : roles.size()) +
                '}';
    }
}
