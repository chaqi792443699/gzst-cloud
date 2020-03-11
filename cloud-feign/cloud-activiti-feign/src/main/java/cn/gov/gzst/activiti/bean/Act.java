package cn.gov.gzst.activiti.bean;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.entity
 * @title:
 * @description: Cache工具类
 * @author: jianliaoliang
 * @date: 2018/5/5 17:09
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class Act extends BaseEntity {

    private String taskId; 		// 任务编号
    private String taskName; 	// 任务名称
    private String taskDefKey; 	// 任务定义Key（任务环节标识）

    private String procInsId; 	// 流程实例ID
    private String procDefId; 	// 流程定义ID
    private String procDefKey; 	// 流程定义Key（流程定义标识）

    private String businessId;		// 业务绑定ID
    private String businessTable;	// 业务绑定Table

    private String title; 		// 任务标题

    private String status; 		// 任务状态（todo/claim/finish）

    private String comment; 	// 任务意见
    private String flag; 		// 意见状态

    private String assignee; // 任务执行人编号
    private String assigneeName; // 任务执行人名称
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date beginDate;	// 开始查询日期
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endDate;	// 结束查询日期

    private String activityId; 		// 获得ID
    private String activityName; 	// 获得名称
    private String activityType; 	// 活动的类型

    private int durationTime; //任务耗时

    private List<Act> list; // 任务列表

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDefKey() {
        return taskDefKey;
    }

    public void setTaskDefKey(String taskDefKey) {
        this.taskDefKey = taskDefKey;
    }

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getProcDefKey() {
        return procDefKey;
    }

    public void setProcDefKey(String procDefKey) {
        this.procDefKey = procDefKey;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessTable() {
        return businessTable;
    }

    public void setBusinessTable(String businessTable) {
        this.businessTable = businessTable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Act> getList() {
        return list;
    }

    public void setList(List<Act> list) {
        this.list = list;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public int getDurationTime() {
        if (beginDate==null || endDate==null){
            return 0;
        }
        durationTime = (int) (beginDate.getTime() - endDate.getTime()) / (1000*3600);
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
}
