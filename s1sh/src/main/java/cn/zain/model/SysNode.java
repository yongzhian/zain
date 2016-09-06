package com.flwrobot.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Zain 2016/9/6 .
 */
public class SysNode implements Serializable {
	private Long id;

	private Long parentId; //parent_id

	private String nodeCode; //node_code
	private String nodeName; //node_name

	private String icon; //icon
	private String url; //url

	private Date createTime; //create_time
	private String isValid; //is_valid

	private int orderNo; //order_no

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "SysNode{" +
				"id=" + id +
				", parentId=" + parentId +
				", nodeCode='" + nodeCode + '\'' +
				", nodeName='" + nodeName + '\'' +
				", icon='" + icon + '\'' +
				", url='" + url + '\'' +
				", createTime=" + createTime +
				", isValid='" + isValid + '\'' +
				", orderNo=" + orderNo +
				'}';
	}
}
