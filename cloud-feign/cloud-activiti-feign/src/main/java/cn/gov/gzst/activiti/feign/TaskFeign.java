package cn.gov.gzst.activiti.feign;

import cn.gov.gzst.activiti.bean.Act;
import cn.gov.gzst.activiti.feign.fallback.TaskFeignFallback;
import cn.gov.gzst.common.bean.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.feign
 * @title:
 * @description: 流程任务
 * @author: jianliaoliang
 * @date: 2018/5/5 14:40
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
@FeignClient(name = "cloud-activiti", fallback = TaskFeignFallback.class)
public interface TaskFeign {

    /**
     *  待办任务
     *
     * @param procDefKey
     * @param taskDefKey
     * @param beginDate
     * @param endDate
     * @return
     */
    @PostMapping(value = "/task/todo")
    public List<Act> todoList(@RequestParam("procDefKey") String procDefKey,
                              @RequestParam("taskDefKey") String taskDefKey,
                              @RequestParam("beginDate") Date beginDate,
                              @RequestParam("endDate") Date endDate);

    /**
     *  已办任务
     *
     * @param procDefKey
     * @param taskDefKey
     * @param beginDate
     * @param endDate
     * @return
     */
    @PostMapping(value = "/task/history")
    public List<Act> history(@RequestParam("procDefKey") String procDefKey,
                             @RequestParam("taskDefKey") String taskDefKey,
                             @RequestParam("beginDate") Date beginDate,
                             @RequestParam("endDate") Date endDate);

    /**
     * 启动流程
     *
     * @param procDefKey
     * @param businessId
     * @param businessTable
     * @param title
     * @return
     */
    @PostMapping(value = "/task/start")
    public ResponseResult start(@RequestParam("procDefKey") String procDefKey,
                                @RequestParam("businessId") String businessId,
                                @RequestParam("businessTable") String businessTable,
                                @RequestParam("title") String title);

    /**
     * 启动流程
     *
     * @param procDefKey
     * @param businessId
     * @param businessTable
     * @param title
     * @return
     */
    @PostMapping(value = "/task/start/complete/first")
    public ResponseResult startCompleteFirst(@RequestParam("procDefKey") String procDefKey,
                                             @RequestParam("businessId") String businessId,
                                             @RequestParam("businessTable") String businessTable,
                                             @RequestParam("title") String title,
                                             @RequestParam("vars") Map<String, Object> vars);
    /**
     * 执行第一个任务
     *
     * @param procInsId
     * @param comment
     * @param title
     * @param vars
     * @return
     */
    @PostMapping(value = "/task/complete/first")
    public ResponseResult completeFirstTask(@RequestParam("procInsId") String procInsId,
                                            @RequestParam("comment") String comment,
                                            @RequestParam("title") String title,
                                            @RequestParam("vars") Map<String, Object> vars);

    /**
     * 执行任务
     *
     * @param taskId
     * @param comment
     * @param title
     * @param vars
     * @return
     */
    @PostMapping(value = "/task/complete")
    public ResponseResult complete(@RequestParam("taskId") String taskId,
                                   @RequestParam("comment") String comment,
                                   @RequestParam("title") String title,
                                   @RequestParam("vars") Map<String, Object> vars);

    /**
     * 签收任务
     *
     * @param taskId
     * @return
     */
    @PostMapping(value = "/task/claim")
    public ResponseResult claim(@RequestParam("taskId") String taskId);

    /**
     * 执行任务
     *
     * @param taskId
     * @param comment
     * @param title
     * @param vars
     * @return
     */
    @PostMapping(value = "/task/claim/complete")
    public ResponseResult claimComplete(@RequestParam("taskId") String taskId,
                                        @RequestParam("comment") String comment,
                                        @RequestParam("title") String title,
                                        @RequestParam("vars") Map<String, Object> vars);


}
