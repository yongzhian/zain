package cn.zain.model.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Entity
@Table(name = "sys_role", schema = "luman", catalog = "")
public class SysRole {
    private Long id;
    private String roleCode;
    private String roleName;
    private String isValid;
    private Timestamp createTime;
    private Set<SysUser> users;
    private Set<SysNode> nodes;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_code", nullable = false, length = 50)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRole sysRole = (SysRole) o;

        if (id != null ? !id.equals(sysRole.id) : sysRole.id != null) return false;
        if (roleCode != null ? !roleCode.equals(sysRole.roleCode) : sysRole.roleCode != null) return false;
        if (roleName != null ? !roleName.equals(sysRole.roleName) : sysRole.roleName != null) return false;
        if (isValid != null ? !isValid.equals(sysRole.isValid) : sysRole.isValid != null) return false;
        if (createTime != null ? !createTime.equals(sysRole.createTime) : sysRole.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }

    @ManyToMany
    @JoinTable(name = "sys_role_node", catalog = "", schema = "luman", joinColumns = @JoinColumn(name = "sys_role_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "sys_node_id", referencedColumnName = "id", nullable = false))
    public Set<SysNode> getNodes() {
        return nodes;
    }

    public void setNodes(Set<SysNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", isValid='" + isValid + '\'' +
                ", createTime=" + createTime +
                ", users=" +  (users == null ? "null" : users.size())  +
                ", nodes=" +  (nodes == null ? "null" : nodes.size())  +
                '}';
    }
}
