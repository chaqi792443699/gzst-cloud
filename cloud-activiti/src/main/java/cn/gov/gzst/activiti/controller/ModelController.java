package cn.gov.gzst.activiti.controller;

import cn.gov.gzst.activiti.service.IModelService;
import cn.gov.gzst.common.common.controller.BaseController;
import cn.gov.gzst.common.mapper.JsonMapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti
 * @title:
 * @description: 流程模型相关
 * @author: jianliaoliang
 * @date: 2018/4/19 12:35
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@Controller
@RequestMapping(value = "model")
public class ModelController extends BaseController {

	@Autowired
	private IModelService modelService;

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public void modelList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam(value = "category",defaultValue ="" ) String category, HttpServletRequest request, HttpServletResponse response) {
		//文章列表
		if (page == null){
			page=1;
		}
		if (limit==null){
			limit=20;
		}
		Page<org.activiti.engine.repository.Model> pageBean = modelService.modelList(
				new Page<org.activiti.engine.repository.Model>(page,limit), category);
		JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";//设置日期格式
		String content = JSON.toJSONString(pageBean,SerializerFeature.WriteDateUseDateFormat);
		StringUtils.printJson(response, content);
	}

	/**
	 * 创建模型
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult create(String name, String key, String description, String category,
								 HttpServletRequest request, HttpServletResponse response) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("创建成功");
		try {
			org.activiti.engine.repository.Model modelData = modelService.create(name, key, description, category);
			responseResult.put("modelId",modelData.getId());
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"创建失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}


	/**
	 * 根据Model部署流程
	 */
	@RequestMapping(value = "{id}/deploy", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult deploy(@PathVariable("id") String id,
								 HttpServletRequest request, HttpServletResponse response) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("部署成功");
		try {
			String message = modelService.deploy(id);
			responseResult.ok(message);
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"部署失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	/**
	 * 导出model的xml文件
	 */
	@RequestMapping(value = "{id}/export")
	public void export(@PathVariable("id") String id, HttpServletResponse response) {
		modelService.export(id, response);
	}

	/**
	 * 删除Model
	 */
	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult delete(@PathVariable("id") String id,
								 HttpServletRequest request, HttpServletResponse response) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("删除成功");
		try {
			modelService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	/**
	 * 更新Model分类
	 */
	@RequestMapping(value = "updateCategory")
	public String updateCategory(String id, String category, RedirectAttributes redirectAttributes) {
		modelService.updateCategory(id, category);
		redirectAttributes.addFlashAttribute("message", "设置成功，模块ID=" + id);
		return "redirect:/act/model";
	}
}
