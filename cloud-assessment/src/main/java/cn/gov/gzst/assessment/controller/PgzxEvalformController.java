package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.*;
import cn.gov.gzst.assessment.service.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.apache.commons.collections.map.HashedMap;
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

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwy
 * @since 2019-05-22
 */
@RestController
@RequestMapping("pgzxevalform")
public class PgzxEvalformController extends BaseBeanController<PgzxEvalform> {
    @Autowired
    private IPgzxEvalformService pgzxEvalformService;
    @Autowired
    private IPgzxSfromstrService pgzxSfromstrService;
    @Autowired
    private IPgzxSfromresService pgzxSfromresService;
    @Autowired
    private FinanceProcessService financeProcessService;
    @Autowired
    private IPgzxProcesslsatService iPgzxProcesslsatService;
    @Autowired
    private IPactProjectbaseService projectbaseService;


    @ApiOperation("用户查询已申报合同记录")
    @GetMapping("userFindList")
    @ResponseBody
    public Object userFindList(String userId, Integer page,Integer limit){
        if(page==null){
            page=1;
        }
        if(limit == null){
            limit = 20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<PgzxEvalform> entityWrapper = new EntityWrapper<>(PgzxEvalform.class);
        if(!StringUtils.isEmpty(userId)){
            entityWrapper.eq("ppb.declarantid",userId);
        }
        pageBean = pgzxEvalformService.userFindContructList(pageBean,entityWrapper);
        List<Map<String,Object>> resltuserlist = pageBean.getRecords();
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<resltuserlist.size();i++){
            Map<String, Object> map = resltuserlist.get(i);
            Map<String, Object> resultMap = new HashMap<>();
            Set<String> keySet = map.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap.put(newKey, map.get(key));
                if (!resultMap.containsKey("approval")){
                    resultMap.put("approval", "0");
                }
                resultMap.put("projectId",resultMap.get("id"));
            }
            list.add(resultMap);
        }
       pageBean.setRecords(list);
        return pageBean;
        }

    @ApiOperation("查看详细信息")
    @GetMapping("FindDetailData")
    @ResponseBody
    public Map FindDetailData(String pactid){
        Map AllData = new HashMap();
        //三次查询数据
        Map base = pgzxEvalformService.Findbase(pactid);
        Map evalform = pgzxEvalformService.Findevalform(pactid);
        List sfromres = pgzxEvalformService.Findsfromres(pactid);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> resultMap = new HashMap<>();
        Set<String> keySet = base.keySet();
        //将Map集合里面的Key转化为小写
        for (String key : keySet) {
            String newKey = key.toLowerCase();
            newKey = newKey.replace("_", "");
            resultMap.put(newKey, base.get(key));
            resultMap.put("projectId",resultMap.get("id"));
        }
        Map<String, Object> resultMap1 = new HashMap<>();
        if(evalform!=null) {
            Set<String> keySet1 = evalform.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet1) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap1.put(newKey, evalform.get(key));
            }
            String str = resultMap1.get("delayreason")+"";
            String[] aa = str.split(",");
            List delayReason = new ArrayList();
            for(int i=0;i<aa.length;i++){
                delayReason.add(aa[i]);
            }
            resultMap1.put("delayreason",delayReason);
        }
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<sfromres.size();i++) {
            Map<String, Object> map = (Map<String, Object>) sfromres.get(i);
            Map<String, Object> resultMap2 = new HashMap<>();
            Set<String> keySet2 = map.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet2) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap2.put(newKey, map.get(key));
            }
            list.add(resultMap2);
        }
        String startTime= formatter.format(resultMap.get("projectstartdate"));
        String entTime= formatter.format(resultMap.get("projectenddate"));
        //组装数据
        resultMap.put("projectstartdate",startTime);
        resultMap.put("projectenddate",entTime);
        AllData.put("base",resultMap);//基本信息：项目信息，经费预算，科技报告等
        AllData.put("evalform",resultMap1); //评价表信息
        AllData.put("sfromres",list); //自评表信息
        return AllData;
    }


    @PostMapping("saveReportAllInfo")
    @ApiOperation("保存信息：科技报告-项目信息-经费预算-自评表-评价表-")
    @ResponseBody
    public ResponseResult saveReportBaseInfo(PgzxEvalform entity, BindingResult result,
                                             HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        //1.获取前台传递的数据，data是自评表得分的数据，pactid是合同号，id是绩效表的id,saveorsub是用来区分保存或提交的，0是保存，1是提交
        String datalist = request.getParameter("data");
        String pactid = request.getParameter("pactid");
        String delayReason= request.getParameter("delayReason");
        String id = request.getParameter("id");
        String saveorsub = request.getParameter("saveorsub");
        String pid =  iPgzxProcesslsatService.findIdByPactid(pactid);
        if (saveorsub==""||saveorsub.isEmpty()){
            return  responseResult.fail(ResponseError.NORMAL_ERROR,"传参失败，保存或提交未区分！");
        }
        JSONArray jsonArray1 = JSONArray.parseArray(delayReason);
         StringBuffer sb = new StringBuffer();
        if(jsonArray1.size()>0){
            for(int i=0;i<jsonArray1.size();i++){
                JSONObject object = jsonArray1.getJSONObject(i);
                if(i<jsonArray1.size()-1) {
                   sb.append(object.getString("delayReason")+",");
                }else {
                    sb.append(object.getString("delayReason"));
                }
            }
        }
        //2.保存评价表的内容-采用自动封装原理
        entity.setDelayReason(sb+"");
        entity.setId(id);
        entity.setPactid(pactid);
        entity.setSubmitdate(new Date());
        pgzxEvalformService.saveOrUpdate(entity);

        //3.循环遍历自评表的数据保存或更新数据库内容
        JSONArray jsonArray = JSONArray.parseArray(datalist);
        if(jsonArray.size()>0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
               PgzxSfromres entity1 = new PgzxSfromres();
               //三级指标编号
                String third_id = json.getString("third_id");
                String selfid = json.getString("selfid");
                String grade =  json.getString("grade");
                int gradeone = Integer.parseInt(grade);
                entity1.setId(selfid);
                entity1.setThirdclassid(third_id);
                entity1.setGrade(gradeone);
                entity1.setPactid(pactid);
                entity1.setFilltime(new Date());
                pgzxSfromresService.saveOrUpdate(entity1);
            }
        }
        //4.添加审批纪律
        FinanceProcess financeProcess = new FinanceProcess();
        PgzxProcesslsat pgzxProcesslsat = new PgzxProcesslsat();
        financeProcess.setPactId(pactid);
        financeProcess.setApprovalTime(new Date());
        if (saveorsub=="0"){
            financeProcess.setApproval("0");
            financeProcess.setApprovalOpinion("保存！");
            financeProcess.setApprovalTime(new Date());
            financeProcess.setPactId(pactid);

           /* pgzxProcesslsat.setId(pid);
            pgzxProcesslsat.setApproval("1");
            pgzxProcesslsat.setApprovalOpinion("保存！");
            pgzxProcesslsat.setApprovalTime(new Date());
            pgzxProcesslsat.setPactid(pactid);*/
        }
        if (saveorsub=="1"){
            financeProcess.setApproval("4");
            financeProcess.setApprovalOpinion("已提交！");
            financeProcess.setApprovalTime(new Date());
            financeProcess.setPactId(pactid);

           /* pgzxProcesslsat.setId(pid);
            pgzxProcesslsat.setApproval("2");
            pgzxProcesslsat.setApprovalOpinion("已提交！");
            pgzxProcesslsat.setApprovalTime(new Date());
            pgzxProcesslsat.setPactid(pactid);*/
        }
        iPgzxProcesslsatService.saveOrUpdate(pgzxProcesslsat);
        financeProcessService.saveOrUpdate(financeProcess);
        return  responseResult.ok("保存成功！");
    }

    /**
     * 根据登录人查询项目
     * @param page        当前第几页
     * @param limit       每页显示的条数
     * @param userId      登录人id
     * @return
     */
    @GetMapping("contractByUser")
    public Object contractByUser(Integer page,Integer limit,String userId){
        if(page ==null){
            page =1;
        }
        if(limit ==null){
            limit =20;
        }
        Page pageBean=new Page(page,limit);
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        if(!StringUtils.isEmpty(userId)){
            entityWrapper.eq("ppb.declarantid", userId);
        }
        pageBean = projectbaseService.contractByUser(pageBean, entityWrapper);
        List<Map<String,Object>> list =pageBean.getRecords();
        List<Map<String,Object>> list1 = new ArrayList<>();
        for(int i= 0;i<list.size();i++){
            Map<String, Object> map = list.get(i);
            Map<String, Object> resultMap = new HashMap<>();
            Set<String> keySet = map.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap.put(newKey, map.get(key));
            }
            Map findevalform = pgzxEvalformService.Findevalform(list.get(i).get("PACTID") + "");
            if(findevalform!=null){
                resultMap.put("status",findevalform.get("STATUS"));
            }else {
                resultMap.put("status",0);
            }
            list1.add(resultMap);
        }
        pageBean.setRecords(list1);
        return pageBean;
    }

   /* *//**
        * 查找列表
        * @param page
         * @param limit
        * @return
        *//*
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
        EntityWrapper<PgzxEvalform> entityWrapper = new EntityWrapper<>(PgzxEvalform.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("pactid",keywords);


                entityWrapper.or().like("impTotal",keywords);


                entityWrapper.or().like("impselfRaised",keywords);


                entityWrapper.or().like("impoffiAppro",keywords);


                entityWrapper.or().like("impcountyFound",keywords);


                entityWrapper.or().like("equipActexpend",keywords);


                entityWrapper.or().like("materialActexpend",keywords);


                entityWrapper.or().like("tprocessingActexpend",keywords);


                entityWrapper.or().like("fuelActexpend",keywords);


                entityWrapper.or().like("meetingActexpend",keywords);


                entityWrapper.or().like("publishActexpend",keywords);


                entityWrapper.or().like("labourActexpend",keywords);


                entityWrapper.or().like("expconsultActexpend",keywords);


                entityWrapper.or().like("otherActexpend",keywords);


                entityWrapper.or().like("indircostActexpend",keywords);


                entityWrapper.or().like("htysTotal",keywords);


                entityWrapper.or().like("actfoundTotal",keywords);


                entityWrapper.or().like("equipAdjdesc",keywords);


                entityWrapper.or().like("materialAdjdesc",keywords);


                entityWrapper.or().like("tprocessingAdjdesc",keywords);


                entityWrapper.or().like("fuelAdjdesc",keywords);


                entityWrapper.or().like("meetingAdjdesc",keywords);


                entityWrapper.or().like("publishAdjdesc",keywords);


                entityWrapper.or().like("labourAdjdesc",keywords);


                entityWrapper.or().like("expconsultAdjdesc",keywords);


                entityWrapper.or().like("otherAdjdesc",keywords);


                entityWrapper.or().like("indirectcostAdjdesc",keywords);


                entityWrapper.or().like("isEstablishment",keywords);


                entityWrapper.or().like("pseniorTitle",keywords);


                entityWrapper.or().like("pintermediateTitle",keywords);


                entityWrapper.or().like("participantDoctor",keywords);


                entityWrapper.or().like("participantMaster",keywords);


                entityWrapper.or().like("participantLeader",keywords);


                entityWrapper.or().like("participantOverstu",keywords);


                entityWrapper.or().like("projectProgress",keywords);


                entityWrapper.or().like("delayReason",keywords);


                entityWrapper.or().like("softapplyNumber",keywords);


                entityWrapper.or().like("softauthorizeNumber",keywords);


                entityWrapper.or().like("publicPnumber",keywords);


                entityWrapper.or().like("publicInumber",keywords);


                entityWrapper.or().like("prizeCity",keywords);


                entityWrapper.or().like("prizeOther",keywords);


                entityWrapper.or().like("zdgjbz",keywords);
                entityWrapper.or().like("industryStandard",keywords);
                entityWrapper.or().like("enterpriseStandard",keywords);
                entityWrapper.or().like("foreignStandard",keywords);
                entityWrapper.or().like("publiciworkNumber",keywords);
                entityWrapper.or().like("publicdworkNumber",keywords);
                entityWrapper.or().like("trtransferNumber",keywords);
                entityWrapper.or().like("trtransferFound",keywords);
                entityWrapper.or().like("servicePlatform",keywords);
                entityWrapper.or().like("projectTraining",keywords);
                entityWrapper.or().like("promotionArea",keywords);
                entityWrapper.or().like("newsb",keywords);
                entityWrapper.or().like("newscx",keywords);
                entityWrapper.or().like("newzsx",keywords);
                entityWrapper.or().like("newsfpxjd",keywords);
                entityWrapper.or().like("newsyjd",keywords);
                entityWrapper.or().like("newjsze",keywords);
                entityWrapper.or().like("newche",keywords);
                entityWrapper.or().like("newlrze",keywords);
                entityWrapper.or().like("newxssr",keywords);
                entityWrapper.or().like("newcz",keywords);
                entityWrapper.or().like("otherReasondesc",keywords);
                entityWrapper.or().like("submitdate",keywords);
                entityWrapper.or().like("status",keywords);


        }
        pageBean= pgzxEvalformService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,pactid,impTotal,impselfRaised,impoffiAppro,impcountyFound,equipActexpend,materialActexpend,tprocessingActexpend,fuelActexpend,meetingActexpend,publishActexpend,labourActexpend,expconsultActexpend,otherActexpend,indircostActexpend,htysTotal,actfoundTotal,equipAdjdesc,materialAdjdesc,tprocessingAdjdesc,fuelAdjdesc,meetingAdjdesc,publishAdjdesc,labourAdjdesc,expconsultAdjdesc,otherAdjdesc,indirectcostAdjdesc,isEstablishment,pseniorTitle,pintermediateTitle,participantDoctor,participantMaster,participantLeader,participantOverstu,projectProgress,delayReason,softapplyNumber,softauthorizeNumber,publicPnumber,publicInumber,prizeCity,prizeOther,zdgjbz,industryStandard,enterpriseStandard,foreignStandard,publiciworkNumber,publicdworkNumber,trtransferNumber,trtransferFound,servicePlatform,projectTraining,promotionArea,newsb,newscx,newzsx,newsfpxjd,newsyjd,newjsze,newche,newlrze,newxssr,newcz,otherReasondesc,submitdate,status");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
     }

    *//**
     * 获得应用程序配置
     * @param id
     * @return
    *//*
    @GetMapping("{id}")
    @ResponseBody
    public PgzxEvalform find(@PathVariable("id") String id){
        return pgzxEvalformService.selectById(id);
    }


    //创建
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(PgzxEvalform entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    @ResponseBody
    public ResponseResult update(PgzxEvalform entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    @ResponseBody
    public ResponseResult doSave(PgzxEvalform entity, HttpServletRequest request,
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
                    pgzxEvalformService.insert(entity);
                } else {
                    pgzxEvalformService.insertOrUpdate(entity);
                }
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
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
                pgzxEvalformService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }*/
}
