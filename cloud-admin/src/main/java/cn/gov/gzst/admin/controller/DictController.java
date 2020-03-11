package cn.gov.gzst.admin.controller;

import cn.gov.gzst.admin.common.bean.ResponseError;
import cn.gov.gzst.admin.entity.Dict;
import cn.gov.gzst.admin.service.IDictGroupService;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.admin.service.IDictService;
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
@RequestMapping("dict")
public class DictController extends BaseBeanController<Dict> {

    @Autowired
    private IDictService dictService;

    @Autowired
    private IDictGroupService dictGroupService;

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    private void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        //文章列表
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        EntityWrapper<Dict> entityWrapper = new EntityWrapper<Dict>(entityClass);
        //entityWrapper.orderBy("createDate",false);
        entityWrapper.orderBy("sort");
        //加入条件
        String keyword = request.getParameter("keyword");
        String gid = request.getParameter("gid");
        if (!StringUtils.isEmpty(gid) && !StringUtils.isEmpty(keyword)) {
            entityWrapper.eq("gid", gid).andNew().like("label", keyword).or().like("value", keyword);
        } else if (!StringUtils.isEmpty(gid)) {
            entityWrapper.eq("gid", gid);
        }
        pageBean = dictService.selectPage(pageBean, entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter("id,label,value,sort,gid,remarks,code");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean, filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult create(Dict entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult update(Dict entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doSave(Dict entity, HttpServletRequest request, HttpServletResponse response,
                                 BindingResult result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("保存成功");
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                responseResult.fail(ResponseError.NORMAL_ERROR, errorMsg);
            } else {
                responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败");
            }
        }
        try {
            if (ObjectUtils.isNullOrEmpty(entity.getId())) {
                dictService.insert(entity);
            } else {
                dictService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            dictService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }


    /**
     * 返回字典label用于显示用
     * @param code
     * @param value
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/value/get", method = RequestMethod.GET)
    @ResponseBody
    public String findVaue(
            @RequestParam(value = "code",defaultValue = "") String code,
            @RequestParam(value = "value", defaultValue = "") String value,HttpServletRequest request,
                              HttpServletResponse response) {
        String content = "";
        if (StringUtils.isEmpty(value)) {
            return content;
        }
        content = this.dictService.getLabel(code,value);
        return content;
    }

    /**
     * 字典
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "selectDictList", method = RequestMethod.POST)
    @ResponseBody
    public List<Dict> selectDictList(HttpServletRequest request,
                                     HttpServletResponse response) {
        return dictService.selectDictList();
    }

}