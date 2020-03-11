package cn.gov.gzst.survey.controller;


import cn.gov.gzst.survey.entity.Scheme;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.survey.entity.Result;
import cn.gov.gzst.survey.service.IResultService;
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
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-13
 */
@RestController
@RequestMapping("result")
public class ResultController extends BaseBeanController<Result> {
    @Autowired
    private IResultService resultService;


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
        EntityWrapper<Result> entityWrapper = new EntityWrapper<>(Result.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);

                entityWrapper.or().like("schemeId",keywords);

                entityWrapper.or().like("Pid",keywords);

                entityWrapper.or().like("questionnaireId",keywords);
        }
        pageBean= resultService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,schemeId,questionId,optionId,reviewer,result,Pid,attachement,questionnaireId,createDate,updateDate");
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
    public Result find(@PathVariable("id") String id){
        return resultService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(Result entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
        String schemeId = request.getParameter("id");
        String pid = request.getParameter("pid");
        String userId = request.getParameter("userId");
        String questionnaireId = request.getParameter("questionnaireId");
        String questionList = request.getParameter("questionList");
        //转化为json数组
        JSONArray jsonArray = JSONArray.parseArray(questionList);
        if(jsonArray.size()>0){
            for(int i=0;i<jsonArray.size();i++){
               JSONObject json = jsonArray.getJSONObject(i);
               JSONArray results= JSONArray.parseArray(json.getString("results"));
               for(int j =0;j<results.size();j++){
                  JSONObject res = results.getJSONObject(j);
                   String optionId = res.getString("optionId");
                   String value = res.getString("value");
                   Result entity1 = new Result();
                   entity1.setSchemeId(schemeId);
                   entity1.setQuestionId(json.getString("id"));
                   entity1.setOptionId(optionId);
                   entity1.setReviewer(userId);
                   entity1.setQuestionnaireId(questionnaireId);
                   entity1.setCreateDate(new Date());
                   entity1.setResult(value);
                   if(questionnaireId!=null){
                       entity1.setType("1");
                   }else {
                       entity1.setType("0");
                   }
                   doSave(entity1, request, response, result);
               }
            }
        }

            return null;
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(Result entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(Result entity, HttpServletRequest request,
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
                    resultService.insert(entity);
                } else {
                    resultService.insertOrUpdate(entity);
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
                resultService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }
}
