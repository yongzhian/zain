package cache;

import java.io.Serializable;
import java.util.Date;

public class RobotTaskDef implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String taskType;

    private String taskName;

    private String taskCode;

    private Integer orderNo;

    private String extendType;

    private String extendHaveEndtime;

    private String extendId;

    private String taskIconUrl;

    private Date createTime;

    private String isValid;

    public RobotTaskDef() {
    }

    public RobotTaskDef(String taskType, String taskName, String taskCode) {
        this.taskType = taskType;
        this.taskName = taskName;
        this.taskCode = taskCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getExtendType() {
        return extendType;
    }

    public void setExtendType(String extendType) {
        this.extendType = extendType;
    }

    public String getExtendHaveEndtime() {
        return extendHaveEndtime;
    }

    public void setExtendHaveEndtime(String extendHaveEndtime) {
        this.extendHaveEndtime = extendHaveEndtime;
    }

    public String getExtendId() {
        return extendId;
    }

    public void setExtendId(String extendId) {
        this.extendId = extendId;
    }

    public String getTaskIconUrl() {
        return taskIconUrl;
    }

    public void setTaskIconUrl(String taskIconUrl) {
        this.taskIconUrl = taskIconUrl;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskCode=").append(taskCode);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", extendType=").append(extendType);
        sb.append(", extendHaveEndtime=").append(extendHaveEndtime);
        sb.append(", extendId=").append(extendId);
        sb.append(", taskIconUrl=").append(taskIconUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", isValid=").append(isValid);
        sb.append("]");
        return sb.toString();
    }
}