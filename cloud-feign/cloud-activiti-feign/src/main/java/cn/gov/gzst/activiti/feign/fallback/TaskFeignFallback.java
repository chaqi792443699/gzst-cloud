package cn.gov.gzst.activiti.feign.fallback;

import cn.gov.gzst.activiti.bean.Act;
import cn.gov.gzst.activiti.feign.TaskFeign;
import cn.gov.gzst.common.bean.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.feign.fallback
 * @title:
 * @description: Cache工具类
 * @author: jianliaoliang
 * @date: 2018/5/5 14:41
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
@Component("taskFeign")
public class TaskFeignFallback implements TaskFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Act> todoList(String procDefKey, String taskDefKey, Date beginDate, Date endDate) {
        return null;
    }

    @Override
    public List<Act> history(String procDefKey, String taskDefKey, Date beginDate, Date endDate) {
        return null;
    }

    @Override
    public ResponseResult start(String procDefKey, String businessId, String businessTable, String title) {
        return null;
    }

    @Override
    public ResponseResult startCompleteFirst(String procDefKey, String businessId, String businessTable, String title, Map<String, Object> vars) {
        return null;
    }

    @Override
    public ResponseResult completeFirstTask(String procInsId, String comment, String title, Map<String, Object> vars) {
        return null;
    }

    @Override
    public ResponseResult complete(String taskId, String comment, String title, Map<String, Object> vars) {
        return null;
    }

    @Override
    public ResponseResult claim(String taskId) {
        return null;
    }

    @Override
    public ResponseResult claimComplete(String taskId, String comment, String title, Map<String, Object> vars) {
        logger.error("调用{}异常:{}", "claimComplete","taskId");
        return null;
    }
}
