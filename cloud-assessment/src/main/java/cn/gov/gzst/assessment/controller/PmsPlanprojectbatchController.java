package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.pms.feign.PmsPlanprojectbatchFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.assessment.entity.PmsPlanprojectbatch;
import cn.gov.gzst.assessment.service.IPmsPlanprojectbatchService;
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

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-09
 */
@Controller
@RequestMapping("pmsplanprojectbatch")
public class PmsPlanprojectbatchController extends BaseBeanController<PmsPlanprojectbatch> {
    @Autowired
    private IPmsPlanprojectbatchService pmsPlanprojectbatchService;

    @Autowired
    private PmsPlanprojectbatchFeign pmsPlanprojectbatchFeign;


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
        EntityWrapper<PmsPlanprojectbatch> entityWrapper = new EntityWrapper<>(PmsPlanprojectbatch.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.or().like("name",keywords);

                entityWrapper.or().like("fieldcodes",keywords);
        }
        pageBean= pmsPlanprojectbatchService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,starttime,endtime,explain,memo,planprojectid,currentstate,annually,openuser,issignonline,applicationtableexplain,openusercode,declarationguideid,workflowdefineid,numberarithmetic,applicationtypecode1,applicationtypecode2,admindepartmentid,enterpriselimit,isstartuniteapprove,pageurl,readscripts,isdisplay,enterpriseparentidex,limitscripts,seq,xingshenusers,modelname,messagemodel,smsattend,smsnotice,smsaccount,reviewexplain,broseruser,status,undertaking,perproject,perteam,persms,perprojectleast,pingshenstarttime,pingshenendtime,city,county,shapeontime,networkevaluationtime,firsttrialtime,unitedreviewtime,competitivereviewtime,mainstatus,jslyzj,hybmglry,qyjdb,gllyzj,lsqdksrq,lsqdjsrq,yzphone,mortality,pagetemplatedtailid,fields,pactmodelname,pactfields,crhmodelname,crhfields,iscrh,fieldcodes");
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
    public PmsPlanprojectbatch find(@PathVariable("id") String id){
        return pmsPlanprojectbatchService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(PmsPlanprojectbatch entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(PmsPlanprojectbatch entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(PmsPlanprojectbatch entity, HttpServletRequest request,
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
                    pmsPlanprojectbatchService.insert(entity);
                } else {
                    pmsPlanprojectbatchService.insertOrUpdate(entity);
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
                pmsPlanprojectbatchService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }


    @GetMapping("/getAnnually")
    public void getAnnually(HttpServletResponse response, HttpServletRequest request){
        List<PmsPlanprojectbatch> list = pmsPlanprojectbatchService.selectAnnually();
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,annually");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(list,filter);
        StringUtils.printJson(response,content);
    }
}
