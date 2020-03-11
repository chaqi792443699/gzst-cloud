package cn.gov.gzst.assessment.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.assessment.entity.PactBase;
import cn.gov.gzst.assessment.service.IPactBaseService;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@Controller
@RequestMapping("pactbase")
public class PactBaseController extends BaseBeanController<PactBase> {
    @Autowired
    private IPactBaseService pactBaseService;


    /**
    * 查找列表
    * @param page
     * @param limit
    * @return
    */
    @GetMapping("list")
    public void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
    HttpServletResponse response){
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<PactBase> entityWrapper = new EntityWrapper<>(PactBase.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("projectId",keywords);


                entityWrapper.or().like("pactno",keywords);


                entityWrapper.or().like("createUserId",keywords);


                entityWrapper.or().like("pactStatus",keywords);


                entityWrapper.or().like("status",keywords);


                entityWrapper.or().like("createTime",keywords);


                entityWrapper.or().like("declarantId",keywords);


                entityWrapper.or().like("declarantDepartId",keywords);


                entityWrapper.or().like("managementStatus",keywords);


                entityWrapper.or().like("isimport",keywords);


        }
        pageBean= pactBaseService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,projectId,pactno,createUserId,pactStatus,status,createTime,declarantId,declarantDepartId,managementStatus,isimport");
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
    public PactBase find(@PathVariable("id") String id){
        return pactBaseService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(PactBase entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(PactBase entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(PactBase entity, HttpServletRequest request,
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
                    pactBaseService.insert(entity);
                } else {
                    pactBaseService.insertOrUpdate(entity);
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
                pactBaseService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }
}
