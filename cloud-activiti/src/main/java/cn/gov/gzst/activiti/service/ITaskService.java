package cn.gov.gzst.activiti.service;

import cn.gov.gzst.activiti.entity.Act;
import com.baomidou.mybatisplus.plugins.Page;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti.service
 * @title:
 * @description: jianliaoliang
 * @author: jianliaoliang
 * @date: 2018/4/19 19:47
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public interface ITaskService {


    /**
     * 获取待办列表
     *
     * @param act
     * @return
     */
    public List<Act> todoList(Act act);

    /**
     * 获取已办任务
     * @param act
     * @return
     */
    public List<Act> historicList(Act act);
    /**
     * 获取已办任务
     * @param page
     * @param act
     * @return
     */
    public Page<Act> historicList(Page<Act> page, Act act);

    /**
     * 获取流转历史列表
     * @param procInsId 流程实例
     * @param startAct 开始活动节点名称
     * @param endAct 结束活动节点名称
     */
    public List<Act> histoicFlowList(String procInsId, String startAct, String endAct);

    /**
     * 获取流程列表
     * @param category 流程分类
     */
    public Page<Object[]> processList(Page<Object[]> page, String category) ;

    /**
     * 获取流程表单（首先获取任务节点表单KEY，如果没有则取流程开始节点表单KEY）
     * @return
     */
    public String getFormKey(String procDefId, String taskDefKey);

    /**
     * 获取流程实例对象
     * @param procInsId
     * @return
     */
    public ProcessInstance getProcIns(String procInsId);

    /**
     * 启动流程
     * @param procDefKey 流程定义KEY
     * @param businessTable 业务表表名
     * @param businessId	业务表编号
     * @return 流程实例ID
     */
    public String startProcess(String procDefKey, String businessTable, String businessId);

    /**
     * 启动流程
     * @param procDefKey 流程定义KEY
     * @param businessTable 业务表表名
     * @param businessId	业务表编号
     * @param title			流程标题，显示在待办任务标题
     * @return 流程实例ID
     */
    public String startProcess(String procDefKey, String businessTable, String businessId, String title);

    /**
     * 启动流程
     * @param procDefKey 流程定义KEY
     * @param businessTable 业务表表名
     * @param businessId	业务表编号
     * @param title			流程标题，显示在待办任务标题
     * @param vars			流程变量
     * @return 流程实例ID
     */
    public String startProcess(String procDefKey, String businessTable, String businessId, String title, Map<String, Object> vars);

    /**
     * 获取任务
     * @param taskId 任务ID
     */
    public Task getTask(String taskId);

    /**
     * 获取任务
     * @param procInstanceId 流程ID
     */
    public List<Task> getCurrentTasks(String procInstanceId);

    /**
     * 删除任务
     * @param taskId 任务ID
     * @param deleteReason 删除原因
     */
    public void deleteTask(String taskId, String deleteReason);

    /**
     * 签收任务
     * @param taskId 任务ID
     * @param userId 签收用户ID
     */
    public void claim(String taskId, String userId);

    /**
     * 提交任务, 并保存意见
     * @param taskId 任务ID
     * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
     * @param comment 任务提交意见的内容
     * @param vars 任务变量
     */
    public void complete(String taskId, String procInsId, String comment, Map<String, Object> vars);

    /**
     * 提交任务, 并保存意见
     * @param taskId 任务ID
     * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
     * @param comment 任务提交意见的内容
     * @param title			流程标题，显示在待办任务标题
     * @param vars 任务变量
     */
    public void complete(String taskId, String procInsId, String comment, String title, Map<String, Object> vars);

    /**
     * 完成第一个任务
     * @param procInsId
     */
    public void completeFirstTask(String procInsId);

    /**
     * 完成第一个任务
     * @param procInsId
     * @param comment
     * @param title
     * @param vars
     */
    public void completeFirstTask(String procInsId, String comment, String title, Map<String, Object> vars);
    /**
     * 添加任务意见
     */
    public void addTaskComment(String taskId, String procInsId, String comment);

    //////////////////  回退、前进、跳转、前加签、后加签、分裂 移植  https://github.com/bluejoe2008/openwebflow  //////////////////////////////////////////////////

    /**
     * 任务后退一步
     */
    public void taskBack(String procInsId, Map<String, Object> variables);

    /**
     * 任务后退至指定活动
     */
    public void taskBack(TaskEntity currentTaskEntity, Map<String, Object> variables);

    /**
     * 任务前进一步
     */
    public void taskForward(String procInsId, Map<String, Object> variables);

    /**
     * 任务前进至指定活动
     */
    public void taskForward(TaskEntity currentTaskEntity, Map<String, Object> variables);

    /**
     * 跳转（包括回退和向前）至指定活动节点
     */
    public void jumpTask(String procInsId, String targetTaskDefinitionKey, Map<String, Object> variables);

    /**
     * 跳转（包括回退和向前）至指定活动节点
     */
    public void jumpTask(String procInsId, String currentTaskId, String targetTaskDefinitionKey, Map<String, Object> variables);

    /**
     * 跳转（包括回退和向前）至指定活动节点
     * @param currentTaskEntity 当前任务节点
     * @param targetTaskDefinitionKey 目标任务节点（在模型定义里面的节点名称）
     * @throws Exception
     */
    public void jumpTask(TaskEntity currentTaskEntity, String targetTaskDefinitionKey, Map<String, Object> variables);


    /**
     * 后加签
     */
    public ActivityImpl[] insertTasksAfter(String procDefId, String procInsId, String targetTaskDefinitionKey, Map<String, Object> variables, String... assignees);
    /**
     * 前加签
     */
    public ActivityImpl[] insertTasksBefore(String procDefId, String procInsId, String targetTaskDefinitionKey, Map<String, Object> variables, String... assignees);
    /**
     * 分裂某节点为多实例节点
     */
    public ActivityImpl splitTask(String procDefId, String procInsId, String targetTaskDefinitionKey, Map<String, Object> variables, String... assignee);

    /**
     * 分裂某节点为多实例节点
     */
    public ActivityImpl splitTask(String procDefId, String procInsId, String targetTaskDefinitionKey, Map<String, Object> variables, boolean isSequential, String... assignees);

    /**
     * 读取带跟踪的图片
     * @param executionId	环节ID
     * @return	封装了各种节点信息
     */
    public InputStream tracePhoto(String processDefinitionId, String executionId);

    /**
     * 流程跟踪图信息
     * @param processInstanceId		流程实例ID
     * @return	封装了各种节点信息
     */
    public List<Map<String, Object>> traceProcess(String processInstanceId) throws Exception;



}
