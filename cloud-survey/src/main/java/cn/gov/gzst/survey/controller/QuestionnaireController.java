package cn.gov.gzst.survey.controller;


import cn.gov.gzst.survey.entity.*;
import cn.gov.gzst.survey.service.*;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
@RestController
@Api(description = "问卷控制器")
@RequestMapping("questionnaire")
public class QuestionnaireController extends BaseBeanController<Questionnaire> {
    @Autowired
    private IQuestionnaireService questionnaireService;

    @Autowired
    private ISchemeService schemeService;

    @Autowired
    private IResultService resultService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IOptionService optionService;

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
        EntityWrapper<Questionnaire> entityWrapper = new EntityWrapper<>(Questionnaire.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){
                entityWrapper.or().like("name",keywords);
        }
        entityWrapper.eq("create_by",userId);
        pageBean= questionnaireService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,schemeId,startDate,closingDate,description,isEnable,createDate,createBy,updateDate,updateBy,status");
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
    public Questionnaire find(@PathVariable("id") String id){
        return questionnaireService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(Questionnaire entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            entity.setStatus("0");
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(Questionnaire entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(Questionnaire entity, HttpServletRequest request,
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
                    questionnaireService.insert(entity);
                } else {
                    questionnaireService.insertOrUpdate(entity);
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
                questionnaireService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }

    //查询启用的问卷
    @GetMapping("{userId}/listByIsEnable")
    public void getQuestionnaireByIsEnable(@RequestParam("page") Integer page,
                                           @RequestParam("limit") Integer limit,@PathVariable("userId") String userId,
                                           HttpServletResponse response,
                                           HttpServletRequest request){
        if(page==null){
            page=1;
        }
        if(limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Questionnaire> entityWrapper = new EntityWrapper<>(Questionnaire.class);
        entityWrapper.eq("isEnable","1");
        entityWrapper.orderBy("closing_date",false);
        String keywords = request.getParameter("keywords");
        if(!StringUtils.isEmpty(keywords)){
            entityWrapper.like("name",keywords);
        }
        pageBean =  questionnaireService.selectPage(pageBean,entityWrapper);
        List<Questionnaire> list = pageBean.getRecords();
        Date date = new Date();
        for(Questionnaire qn : list){
            EntityWrapper<Result> resultEntityWrapper = new EntityWrapper<>(Result.class);
            resultEntityWrapper.eq("reviewer",userId).eq("questionnaire_id",qn.getId());
            List<Result> resultList = resultService.selectList(resultEntityWrapper);
            for(Result rs : resultList){
                qn.setAnswerDate(rs.getCreateDate());
            }
            if(resultList.size()>0){
                qn.setStatus("1");
            }else {
                qn.setStatus("0");
            }
            if(date.getTime()>qn.getClosingDate().getTime()){
                qn.setIsValidity("1");
            }
            if(date.getTime()<qn.getStartDate().getTime()){
                qn.setIsValidity("2");
            }
            if(qn.getStartDate().getTime()<date.getTime()&&date.getTime()<qn.getClosingDate().getTime()){
                qn.setIsValidity("3");
            }
        }

        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,schemeId,startDate,closingDate,description,isEnable,createDate,createBy,updateDate,updateBy,status,answerDate,isValidity");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
    }


    //根据问卷id获取问卷信息
    @GetMapping("{naireId}/getQuestionnaireByNaireId")
    public List<Object> getQuestionnaireByNaireId(@PathVariable("naireId") String naireId){
        return  questionnaireService.getQuestionnaireByNaireId(naireId);
    }

    //查看问卷结果
    @GetMapping("{userId}/{naireId}/selectNaire")
    public List<Object> selectNaire(@PathVariable("naireId") String questionnaireId,@PathVariable("userId") String userId){
        return questionnaireService.selectNaire(questionnaireId,userId);
    }

    //统计问卷调查结果
    @GetMapping("{naireId}/{questionId}/statistics")
    public Question statistics(@PathVariable("naireId") String naireId, @PathVariable("questionId") String questionId){
        return questionnaireService.statistics(naireId,questionId);
    }

    @ApiOperation(value ="根据问卷id获取问卷题目",notes = "根据问卷id获取问卷题目！")
    @ApiImplicitParam(name = "naireId",value = "问卷id",dataType = "String")
    @GetMapping("{naireId}/getQustionBynaireId")
    public List<Object> getQustionBynaireId(@PathVariable("naireId") String naireId){
        return questionnaireService.getQustionBynaireId(naireId);
    }


    @ApiOperation(value = "导出问卷统计结果")
    @ApiImplicitParam(name = "naireId",value = "问卷id",dataType = "String")
    @GetMapping("{naireId}/exportResult")
    public String export(@PathVariable("naireId") String naireId){
        return questionnaireService.exportResult(naireId);
    }
}