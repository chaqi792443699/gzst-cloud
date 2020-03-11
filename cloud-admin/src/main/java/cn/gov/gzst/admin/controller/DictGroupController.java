package cn.gov.gzst.admin.controller;

import cn.gov.gzst.admin.entity.Dict;
import cn.gov.gzst.admin.entity.DictGroup;
import cn.gov.gzst.admin.service.IDictGroupService;
import cn.gov.gzst.admin.service.IDictService;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("dict/group")
public class DictGroupController extends BaseBeanController<DictGroup> {

	@Autowired
	private IDictGroupService dictGroupService;

	@Autowired
	private IDictService dictService;

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
	private void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
		//文章列表
		if (page == null){
			page=1;
		}
		if (limit==null){
			limit=20;
		}
		Page pageBean = new Page(page,limit);
		EntityWrapper<DictGroup> entityWrapper = new EntityWrapper<DictGroup>(entityClass);
		entityWrapper.orderBy("createDate",false);
		//加入条件
		String keyword=request.getParameter("keyword");
		if (!StringUtils.isEmpty(keyword)){
			entityWrapper.like("name",keyword).or().like("code",keyword);
		}
		pageBean= dictGroupService.selectPage(pageBean,entityWrapper);
		PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,code,sort,remarks");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		String content = JSON.toJSONString(pageBean,filter);
		StringUtils.printJson(response, content);
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult create(DictGroup entity, BindingResult result,
								 HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult update(DictGroup entity, BindingResult result,
								 HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult doSave(DictGroup entity, HttpServletRequest request, HttpServletResponse response,
								 BindingResult result) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("保存成功");
		if (hasError(entity, result)) {
			// 错误提示
			String errorMsg = errorMsg(result);
			if (!StringUtils.isEmpty(errorMsg)) {
				responseResult.fail(ResponseError.NORMAL_ERROR,errorMsg);
			} else {
				responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败");
			}
		}
		try {
			if (ObjectUtils.isNullOrEmpty(entity.getId())) {
				dictGroupService.insert(entity);
			} else {
				dictGroupService.insertOrUpdate(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
		}
		return responseResult;
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult delete(@PathVariable("id") String id) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.ok("删除成功");
		try {
			dictGroupService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
		}
		return responseResult;
	}


	/**
	 * 根据分组编码，查询字典（用户前端下拉或多选、单选的情况）
	 * @param code
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "{code}/list", method = { RequestMethod.GET, RequestMethod.POST })
	private void findDictsByGroupCode(@PathVariable("code") String code,HttpServletRequest request,
						  HttpServletResponse response) throws IOException {
		EntityWrapper<DictGroup> entityWrapper = new EntityWrapper<DictGroup>(entityClass);
		entityWrapper.eq("code",code);
		DictGroup group = this.dictGroupService.selectOne(entityWrapper);
		if (group == null) {
			StringUtils.printJson(response, "数据有误！");
			return;
		}
		EntityWrapper<Dict> entityWrapper1 = new EntityWrapper<>(Dict.class);
		entityWrapper1.eq("gid",group.getId());
		entityWrapper1.orderBy("sort",true);
		List<Dict> dicts = this.dictService.selectList(entityWrapper1);
		PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter();
		propertyPreFilterable.addIncludeFilter(Dict.class,new String[]{"id","label","value"});
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		String content = JSON.toJSONString(dicts,filter);
		StringUtils.printJson(response, content);
	}

}