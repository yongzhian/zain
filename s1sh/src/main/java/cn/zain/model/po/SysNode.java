package cn.zain.model.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Entity
@Table(name = "sys_node", schema = "luman", catalog = "")
public class SysNode {
    private Long id;
    private String nodeCode;
    private String nodeName;
    private String icon;
    private String url;
    private Timestamp createDate;
    private String isValid;
    private Integer orderNo;
    private SysNode parentNode;
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
    @Column(name = "node_code", nullable = false, length = 50)
    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    @Basic
    @Column(name = "node_name", nullable = false, length = 50)
    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @Basic
    @Column(name = "icon", nullable = true, length = 50)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 200)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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
    @Column(name = "order_no", nullable = false)
    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysNode sysNode = (SysNode) o;

        if (id != null ? !id.equals(sysNode.id) : sysNode.id != null) return false;
        if (nodeCode != null ? !nodeCode.equals(sysNode.nodeCode) : sysNode.nodeCode != null) return false;
        if (nodeName != null ? !nodeName.equals(sysNode.nodeName) : sysNode.nodeName != null) return false;
        if (icon != null ? !icon.equals(sysNode.icon) : sysNode.icon != null) return false;
        if (url != null ? !url.equals(sysNode.url) : sysNode.url != null) return false;
        if (createDate != null ? !createDate.equals(sysNode.createDate) : sysNode.createDate != null) return false;
        if (isValid != null ? !isValid.equals(sysNode.isValid) : sysNode.isValid != null) return false;
        if (orderNo != null ? !orderNo.equals(sysNode.orderNo) : sysNode.orderNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nodeCode != null ? nodeCode.hashCode() : 0);
        result = 31 * result + (nodeName != null ? nodeName.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public SysNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(SysNode parentNode) {
        this.parentNode = parentNode;
    }

    @ManyToMany(mappedBy = "nodes")
    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysNode{" +
                "id=" + id +
                ", nodeCode='" + nodeCode + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                ", isValid='" + isValid + '\'' +
                ", orderNo=" + orderNo +
                ", parentNode=" + parentNode +
                ", roles=" +  (roles == null ? "null" : roles.size())  +
                '}';
    }
}
