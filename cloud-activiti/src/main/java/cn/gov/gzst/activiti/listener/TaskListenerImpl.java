package cn.gov.gzst.activiti.listener;

import cn.gov.gzst.activiti.entity.FetchUserTask;
import cn.gov.gzst.activiti.service.IFetchUserTaskService;
import cn.gov.gzst.common.utils.SpringContextHolder;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.activiti.listener
 * @title:
 * @description: 获取用户信息的任务监听
 * @author: jianliaoliang
 * @date: 2018/6/28 16:22
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class TaskListenerImpl implements Serializable,TaskListener {
    private Expression enterpriseType;
    private Expression enterpriseValue;
    private Expression roleCode;
    private Expression fetchUserUrl;
    private Expression isCorporation;

    /**
     * 可以设置任务的办理人（个人组人和组任务）
     */
    @Override
    public void notify(DelegateTask delegateTask) {
        //指定组任务
        Map<String, Object>  variables = delegateTask.getVariables();
        IFetchUserTaskService fetchUserTaskService = SpringContextHolder.getApplicationContext().getBean(IFetchUserTaskService.class);
        FetchUserTask fetchUserTask = new FetchUserTask();
        fetchUserTask.setEid((String) variables.get("eid"));
        fetchUserTask.setUid((String) variables.get("uid"));
        fetchUserTask.setSubmitEid((String) variables.get("submitEid"));
        fetchUserTask.setSubmitUid((String) variables.get("submitUid"));
        fetchUserTask.setVariables(JSON.toJSONString(variables));
        // 类型
        if (this.enterpriseType!=null){
            Object value = enterpriseType.getValue(delegateTask);
            fetchUserTask.setEnterpriseType(String.valueOf(value));
        }
        // 类型值
        if (this.enterpriseValue!=null){
            Object value = enterpriseValue.getValue(delegateTask);
            fetchUserTask.setEnterpriseValue(String.valueOf(value));
        }
        // 查询用户URL
        if (this.fetchUserUrl!=null){
            Object value = fetchUserUrl.getValue(delegateTask);
            fetchUserTask.setFetchUserUrl(String.valueOf(value));
        }
        // 是否法人单位
        if (this.isCorporation!=null){
            Object value = isCorporation.getValue(delegateTask);
            fetchUserTask.setIsCorporation(String.valueOf(value));
        }
        // 查询用户URL
        if (this.roleCode!=null){
            Object value = roleCode.getValue(delegateTask);
            fetchUserTask.setRoleCode(String.valueOf(value));
        }
        fetchUserTask.setTaskId(delegateTask.getId());
        fetchUserTask.setAddDate(new Date());
        fetchUserTaskService.save(fetchUserTask);
    }

    public Expression getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(Expression enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Expression getEnterpriseValue() {
        return enterpriseValue;
    }

    public void setEnterpriseValue(Expression enterpriseValue) {
        this.enterpriseValue = enterpriseValue;
    }

    public Expression getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Expression roleCode) {
        this.roleCode = roleCode;
    }

    public Expression getFetchUserUrl() {
        return fetchUserUrl;
    }

    public void setFetchUserUrl(Expression fetchUserUrl) {
        this.fetchUserUrl = fetchUserUrl;
    }

    public Expression getIsCorporation() {
        return isCorporation;
    }

    public void setIsCorporation(Expression isCorporation) {
        this.isCorporation = isCorporation;
    }
}
