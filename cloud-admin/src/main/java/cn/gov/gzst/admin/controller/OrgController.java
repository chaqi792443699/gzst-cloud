package cn.gov.gzst.admin.controller;

import cn.gov.gzst.admin.entity.Org;
import cn.gov.gzst.admin.service.IOrgService;
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
import java.util.List;

@Controller
@RequestMapping("org")
public class OrgController extends BaseBeanController<Org> {

    @Autowired
    private IOrgService orgService;

    /**
     * 查找列表
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("list")
    public void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                         HttpServletResponse response) {
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        EntityWrapper<Org> entityWrapper = new EntityWrapper<>(Org.class);
        entityWrapper.orderBy("sort");
        entityWrapper.orderBy("parent_ids");
        //加入条件
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)) {
            entityWrapper.like("name", keywords).or().like("remarks", keywords);
        }
        pageBean = orgService.selectPage(pageBean, entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(Org.class, new String[]{"id","name","parentId","category", "parentIds","userId", "level", "parents", "sort", "hasChildren", "remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 获得菜单数据
     *
     * @param id
     * @return
     */
    @GetMapping("{id}/get")
    @ResponseBody
    public Org find(@PathVariable("id") String id) {
        return orgService.selectById(id);
    }


    //创建
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(Org entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //修改
    @PostMapping("{id}/update")
    @ResponseBody
    public ResponseResult update(Org entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //保存
    @PostMapping("/save")
    @ResponseBody
    public ResponseResult doSave(Org entity, HttpServletRequest request,
                                 HttpServletResponse response, BindingResult result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("保存成功");
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                responseResult.fail(cn.gov.gzst.common.bean.ResponseError.NORMAL_ERROR, errorMsg);
            } else {
                responseResult.fail(cn.gov.gzst.common.bean.ResponseError.NORMAL_ERROR, "保存失败");
            }
        }
        try {
            if (ObjectUtils.isNullOrEmpty(entity.getId())) {
                orgService.insert(entity);
            } else {
                orgService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(cn.gov.gzst.common.bean.ResponseError.NORMAL_ERROR, "保存失败!原因:" + e.getMessage());
        }
        return responseResult;
    }

    //删除
    @GetMapping("{id}/delete")
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            orgService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }

    /**
     * 树列表
     *
     * @param id
     * @return
     */
    @GetMapping("nodes/get")
    public void findParentNodes(@RequestParam(value = "id", defaultValue = "") String id,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        EntityWrapper<Org> entityWrapper = new EntityWrapper<>(Org.class);
        entityWrapper.orderBy("parent_ids");
        entityWrapper.orderBy("sort");
        String category = request.getParameter("category");
        String keyword = request.getParameter("keyword");
        if (!StringUtils.isEmpty(category)) {
            entityWrapper.eq("category",category);
        }
        if (StringUtils.isEmpty(id)) {
            if (StringUtils.isEmpty(keyword)) {
                entityWrapper.andNew().isNull("parent_id").or().eq("parent_id", "");
            }
        } else {
            entityWrapper.eq("parent_id", id);
        }
        String extId = request.getParameter("extId");
        if (!StringUtils.isEmpty(extId)) {
            entityWrapper.ne("id", extId);
        }
        if (!StringUtils.isEmpty(keyword)) {
            entityWrapper.like("name",keyword);
        }
        List<Org> dataList = orgService.selectList(entityWrapper);
        try {
            dataList = orgService.formatNodes(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(Org.class, new String[]{"id","name","userId","parentId","category", "parentIds", "level", "parents", "sort", "hasChildren", "remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(dataList, filter);
        StringUtils.printJson(response, content);
    }

}