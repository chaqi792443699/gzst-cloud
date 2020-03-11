package cn.gov.gzst.oss.controller;

import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.oss.entity.Group;
import cn.gov.gzst.oss.entity.Model;
import cn.gov.gzst.oss.service.IGroupService;
import cn.gov.gzst.oss.service.IModelService;
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
import java.util.Map;

@Controller
@RequestMapping("/group")
public class GroupController extends BaseBeanController<Group> {

    @Autowired
    private IGroupService groupService;

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
        EntityWrapper<Group> entityWrapper = new EntityWrapper<Group>(entityClass);
        //加入条件
        String keyword=request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)){
            entityWrapper.like("name",keyword).or().like("code",keyword);
        }
        pageBean= groupService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,code,sort,sceneId,remarks");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult create(Group entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult update(Group entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doSave(Group entity, HttpServletRequest request, HttpServletResponse response,
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
                groupService.insert(entity);
            } else {
                groupService.insertOrUpdate(entity);
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
            groupService.deleteById(id);
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
    private void findsByGroupCode(@PathVariable("code") String code,HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        EntityWrapper<Group> entityWrapper = new EntityWrapper<Group>(entityClass);
        entityWrapper.eq("code",code);
        String pid = request.getParameter("pid");
        Group group = this.groupService.selectOne(entityWrapper);
        if (group == null) {
            StringUtils.printJson(response, "数据有误！");
            return;
        }
        EntityWrapper<Model> entityWrapper1 = new EntityWrapper<>(Model.class);
        entityWrapper1.eq("gid",group.getId());
        entityWrapper1.orderBy("sort",true);
        List<Map> models = this.modelService.selectModels(pid,entityWrapper1);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(Model.class,new String[]{"id","name","size","require","type","remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(models,filter);
        StringUtils.printJson(response, content);
    }

}