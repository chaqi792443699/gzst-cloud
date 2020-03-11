package cn.gov.gzst.survey.controller;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.survey.entity.Scheme;
import cn.gov.gzst.survey.service.ISchemeService;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
@RestController
@RequestMapping("scheme")
public class SchemeController extends BaseBeanController<Scheme> {
    @Autowired
    private ISchemeService schemeService;


    /**
    * 查找列表
    * @param page
     * @param limit
    * @return
    */
    @GetMapping("{userId}/list")
    public void ajaxList(@PathVariable("userId") String userId,@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
    HttpServletResponse response){
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Scheme> entityWrapper = new EntityWrapper<>(Scheme.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){
            entityWrapper.or().like("name",keywords);
            entityWrapper.or().like("isEnable",keywords);
        }
        entityWrapper.eq("create_by",userId);
        pageBean= schemeService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,groupName,description,isEnable,sort,createDate,createBy,updateDate,updateBy");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
     }

    /**
     * 获得应用程序配置
     * @param id
     * @return
    */
    @GetMapping("{id}")
    public Scheme find(@PathVariable("id") String id){
        return schemeService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(Scheme entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            entity.setCreateDate(new Date());
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(Scheme entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            entity.setUpdateDate(new Date());
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(Scheme entity, HttpServletRequest request,
                HttpServletResponse response,BindingResult result) {
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
                    schemeService.insert(entity);
                } else {
                    schemeService.insertOrUpdate(entity);
                }
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
           }
           return responseResult;
     }

    //删除
    @GetMapping("{id}/delete")
    public ResponseResult delete(@PathVariable("id") String id) {
           ResponseResult responseResult = new ResponseResult();
           responseResult.ok("删除成功");
           try {
                schemeService.deleteById(id);

           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }

    @GetMapping("/getSchemeList")
    public void getSchemeList(HttpServletResponse response){
        EntityWrapper<Scheme> entityWrapper = new EntityWrapper<>(Scheme.class);
        List<Scheme> list = schemeService.selectList(entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,groupName,description,isEnable,sort,createDate,createBy,updateDate,updateBy");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(list,filter);
        StringUtils.printJson(response,content);
    }

    @GetMapping("{id}/getScheme")
    public Scheme getList(@PathVariable("id") String id){
        return schemeService.getScheme(id);
    }
}
