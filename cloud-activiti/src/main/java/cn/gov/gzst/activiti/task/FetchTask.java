package cn.gov.gzst.activiti.task;

import cn.gov.gzst.activiti.entity.FetchUserTask;
import cn.gov.gzst.activiti.service.IFetchUserTaskService;
import cn.gov.gzst.admin.feign.UserFeign;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.activiti.engine.TaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.task
 * @title:
 * @description: 查找用户任务
 * @author: jianliaoliang
 * @date: 2018/6/13 15:12
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
@Component("fetchTask")
public class FetchTask{
    public final Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private TaskService taskService;
    @Autowired
    private IFetchUserTaskService fetchUserTaskService;
    @Autowired
    private UserFeign userFeign;

    private Boolean isRun=Boolean.FALSE;
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 检查回复并写入到日志中
     */
    @Scheduled(fixedRate = 10000)
    public void run() {
        log.info(" 用户获取开始......................................" + (new Date()));
        if (!isRun) {
            List<FetchUserTask>  fetchUserTaskList = fetchUserTaskService.selectList(
                     new EntityWrapper<FetchUserTask>()
                             .eq("fetch_status",FetchUserTask.FETCH_STATUS_WAIT)
                             .or().eq("fetch_status",FetchUserTask.FETCH_STATUS_FAIL));
            try {
                for (FetchUserTask fetchUserTask: fetchUserTaskList) {
                    try {
                        String fetchUserUrl = fetchUserTask.getFetchUserUrl();
                        String taskId = fetchUserTask.getTaskId();
                        if (!StringUtils.isEmpty(fetchUserUrl)){ //通过Url定义用户
                            //获取用户
                            ResponseEntity<String> responseEntity = restTemplate.getForEntity(fetchUserUrl, String.class);
                            String userId = responseEntity.getBody();
                            if (!StringUtils.isEmpty(userId)){
                                String[] userIds = userId.split(",");
                                for (String userIdItem:userIds) {
                                    taskService.addCandidateUser(taskId,userIdItem);
                                }
                            }
                        } else { //通过类型定义用户
                            ResponseResult responseResult = new ResponseResult();
                            responseResult.putObject(fetchUserTask);
                            List<String> userIdList= null;// userFeign.fetchActivitiUser(responseResult);
                            if (userIdList == null){
                                continue;
                            }
                            for (String userIdItem:userIdList) {
                                taskService.addCandidateUser(taskId,userIdItem);
                            }
                            if (userIdList.size()>0){
                                fetchUserTask.setFetchStatus(FetchUserTask.FETCH_STATUS_SUCCESS);
                                fetchUserTask.setFetchTime(new Date());
                                fetchUserTask.setFetchMsg("获取成功");
                                fetchUserTaskService.saveOrUpdate(fetchUserTask);
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        fetchUserTask.setFetchMsg(e.getMessage());
                        fetchUserTask.setFetchStatus(FetchUserTask.FETCH_STATUS_FAIL);
                        fetchUserTask.setFetchTime(new Date());
                        fetchUserTaskService.saveOrUpdate(fetchUserTask);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                isRun = Boolean.FALSE;
            }
        }
        log.info(" 用户获取结束......................................" + (new Date()));
    }
}
