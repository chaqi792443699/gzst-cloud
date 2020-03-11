package cn.gov.gzst.activiti.controller;

import cn.gov.gzst.activiti.entity.Act;
import cn.gov.gzst.activiti.service.ITaskService;
import cn.gov.gzst.activiti.utils.ActUtils;
import cn.gov.gzst.activiti.utils.ProcessDefCache;
import cn.gov.gzst.common.common.controller.BaseController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti
 * @title:
 * @description: 流程个人任务相关Controller
 * @author: jianliaoliang
 * @date: 2018/4/19 12:35
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@RestController
@RequestMapping(value = "task")
public class TaskController extends BaseController {

	@Autowired
	private ITaskService taskService;

	/**
	 * 获取待办列表
	 *
	 * @param act
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "todo")
	public void  todoList(Act act, HttpServletResponse response) throws Exception {
		List<Act> list = taskService.todoList(act);
		PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("taskId,taskName,taskDefKey,procInsId,procDefId,procDefKey,businessId,businessTable,title,status,comment,flag,assignee,assigneeName,beginDate, endDate,list,formKey");
		SerializeFilter filter = propertyPreFilterable.constructFilter(Act.class);
		String content = JSON.toJSONString(list,filter);
		StringUtils.printJson(response, content);
	}
	/**
	 * 获取已办任务
	 *
	 * @param act
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "history")
	public void historyList(Act act, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取已办任务
		List<Act> list =taskService.historicList(act);
		PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("taskId,taskName,taskDefKey,procInsId,procDefId,procDefKey,businessId,businessTable,title,status,comment,flag,assignee,assigneeName,beginDate, endDate,list");
		SerializeFilter filter = propertyPreFilterable.constructFilter(Act.class);
		String content = JSON.toJSONString(list,filter);
		StringUtils.printJson(response, content);
	}
	/**
	 * 获取已办任务
	 *
	 * @param act
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "historic")
	public void historicList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, Act act, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取已办任务
		if (page == null){
			page=1;
		}
		if (limit==null){
			limit=20;
		}
		Page<Act> pageBean = new Page<Act>(page,limit);
		pageBean = taskService.historicList(pageBean, act);
		String content = JSON.toJSONString(pageBean);
		StringUtils.printJson(response, content);
	}

	/**
	 * 获取流转历史列表
	 * @param act
	 * @param startAct
	 * @param endAct
	 * @return
	 */
	@PostMapping(value = "histoicFlow")
	public void histoicFlow(Act act, String startAct, String endAct,HttpServletResponse response){
		List<Act> histoicFlowList=new ArrayList<Act>();
		if (StringUtils.isNotBlank(act.getProcInsId())){
		    histoicFlowList = taskService.histoicFlowList(act.getProcInsId(), startAct, endAct);
		}
		PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("taskId,taskName,taskDefKey,procInsId,procDefId,procDefKey,businessId,businessTable,title,status,comment,flag,assignee,assigneeName,beginDate, endDate,list,activityId,activityName,activityType");
		SerializeFilter filter = propertyPreFilterable.constructFilter(Act.class);
		String content = JSON.toJSONString(histoicFlowList,filter);
		StringUtils.printJson(response, content);
	}
	
	/**
	 * 获取流程列表
	 * @param category 流程分类
	 */
	@GetMapping(value = "process")
	public void processList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,String category, HttpServletRequest request, HttpServletResponse response) {
		//获取流程列表
		if (page == null){
			page=1;
		}
		if (limit==null){
			limit=20;
		}
		Page<Object[]> pageBean = new Page<Object[]>(page, limit);
		pageBean = taskService.processList(pageBean, category);
		String content = JSON.toJSONString(pageBean);
		StringUtils.printJson(response, content);
	}

	/**
	 * 获取流程表单
	 *
	 * @param act
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value = "form")
	public String form(Act act, HttpServletRequest request, Model model){
		
		// 获取流程XML上的表单KEY
		String formKey = taskService.getFormKey(act.getProcDefId(), act.getTaskDefKey());

		// 获取流程实例对象
		if (act.getProcInsId() != null){
			act.setProcIns(taskService.getProcIns(act.getProcInsId()));
		}
		
		return "redirect:" + ActUtils.getFormUrl(formKey, act);
	}

	/**
	 * 启动流程
	 *
	 * @param act
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "start")
	@ResponseBody
	public ResponseResult start(Act act) throws Exception {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("启动成功");
		try {
			String procInsId=taskService.startProcess(act.getProcDefKey(), act.getBusinessId(), act.getBusinessTable(), act.getTitle());
			responseResult.put("procInsId",procInsId);
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"启动失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	/**
	 * 签收任务
	 * @param act
	 * @return
	 */
	@RequestMapping(value = "claim")
	@ResponseBody
	public ResponseResult claim(Act act) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("签收成功");
		try {
			String userId = "";//UserUtils.getUid();
			taskService.claim(act.getTaskId(), userId);
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"签收失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	/**
	 * 启动并完成第一个任务
	 *
	 * @param act
	 * @return
	 */
	@RequestMapping(value = "start/complete/first")
	@ResponseBody
	public ResponseResult startCompleteFirst(Act act,HttpServletRequest request) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("完成任务成功");
		try {
			Map<String,Object> vars=new HashMap<>();
			Enumeration enu=request.getParameterNames();
			while(enu.hasMoreElements()){
				String key=(String)enu.nextElement();
				vars.put(key,request.getParameter(key));
			}
			String procInsId=taskService.startProcess(act.getProcDefKey(), act.getBusinessId(), act.getBusinessTable(), act.getTitle());
			taskService.completeFirstTask(procInsId, act.getComment(),act.getTitle(), vars);
			responseResult.put("procInsId",procInsId);
			nextTask(responseResult,procInsId);
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"完成任务失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	/**
	 * 完成第一个任务
	 *
	 * @param act
	 * @return
	 */
	@RequestMapping(value = "complete/first")
	@ResponseBody
	public ResponseResult completeFirst(Act act,HttpServletRequest request) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("完成任务成功");
		try {
			Map<String,Object> vars=new HashMap<>();
			Enumeration enu=request.getParameterNames();
			while(enu.hasMoreElements()){
				String key=(String)enu.nextElement();
				vars.put(key,request.getParameter(key));
			}
			taskService.completeFirstTask(act.getProcInsId(), act.getComment(),act.getTitle(), vars);
			nextTask(responseResult,act.getProcInsId());
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"完成任务失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	/**
	 * 完成任务
	 *
	 * @param act
	 * @return
	 */
	@RequestMapping(value = "claim/complete")
	@ResponseBody
	public ResponseResult claimComplete(Act act,HttpServletRequest request) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("完成任务成功");
		try {
			//先认领
			String userId = "";//UserUtils.getUid();
			if (!StringUtils.isEmpty(userId)) {
				taskService.claim(act.getTaskId(), userId);
			}
			Map<String,Object> vars=new HashMap<>();
			Enumeration enu=request.getParameterNames();
			while(enu.hasMoreElements()){
				String key=(String)enu.nextElement();
				vars.put(key,request.getParameter(key));
			}
			// 获得流程ID
			String procInsId = act.getProcInsId();
			Task task = taskService.getTask(act.getTaskId());
			if (task!=null) {
				if (StringUtils.isEmpty(procInsId)) {
					procInsId = taskService.getTask(act.getTaskId()).getProcessInstanceId();
				}
				//完成
				taskService.complete(act.getTaskId(), act.getProcInsId(), act.getComment(), vars);
				//获得当前任务大的ID
				nextTask(responseResult,procInsId);
			}else{
				responseResult.ok("该任务已经执行");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"完成任务失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	public void nextTask(ResponseResult responseResult,String procInsId){
		//获得当前任务大的ID
		List<Task> taskList = taskService.getCurrentTasks(procInsId);
		if (taskList==null){
			responseResult.put("isEnd",Boolean.TRUE);
		}else{
			responseResult.put("isEnd",Boolean.FALSE);
			responseResult.put("taskName",taskList.get(0).getName());
			responseResult.put("taskDefKey",taskList.get(0).getTaskDefinitionKey());
			List<Act> result = new ArrayList<Act>();
			// 查询列表
			for (Task task : taskList) {
				Act e = new Act();
				e.setTask(task);
				e.setVars(task.getProcessVariables());
				e.setProcDef(ProcessDefCache.get(task.getProcessDefinitionId()));
				e.setStatus("todo");
				result.add(e);
			}
			responseResult.putList("tasks",result,"taskId,taskName,taskDefKey,procInsId,procDefId,procDefKey,businessId,businessTable,title,status,comment,flag,assignee,assigneeName,beginDate, endDate,list,formKey");
		}
	}
	/**
	 * 完成任务
	 *
	 * @param act
	 * @return
	 */
	@RequestMapping(value = "complete")
	@ResponseBody
	public ResponseResult complete(Act act) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("完成任务成功");
		try {
			taskService.complete(act.getTaskId(), act.getProcInsId(), act.getComment(), act.getVars().getVariableMap());
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"完成任务失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	/**
	 * 删除任务
	 * @param taskId 流程实例ID
	 * @param reason 删除原因
	 */
	@RequestMapping(value = "deleteTask")
	public ResponseResult deleteTask(String taskId, String reason, RedirectAttributes redirectAttributes) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("删除任务成功");
		if (StringUtils.isBlank(reason)){
			responseResult.ok("请填写删除原因");
		}else{
			try {
				taskService.deleteTask(taskId, reason);
			} catch (Exception e) {
				e.printStackTrace();
				responseResult.fail(ResponseError.NORMAL_ERROR,"删除任务失败!<br />原因:" + e.getMessage());
			}
		}
		return responseResult;
	}
	
	/**
	 * 读取带跟踪的图片
	 */
	@RequestMapping(value = "trace/photo/{procDefId}/{execId}")
	public void tracePhoto(@PathVariable("procDefId") String procDefId, @PathVariable("execId") String execId, HttpServletResponse response) throws Exception {
		InputStream imageStream = taskService.tracePhoto(procDefId, execId);
		// 输出资源内容到相应对象
		byte[] b = new byte[1024];
		int len;
		while ((len = imageStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	/**
	 * 输出跟踪流程信息
	 *
	 * @param proInsId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "trace/info/{proInsId}")
	public List<Map<String, Object>> traceInfo(@PathVariable("proInsId") String proInsId) throws Exception {
		List<Map<String, Object>> activityInfos = taskService.traceProcess(proInsId);
		return activityInfos;
	}

}
