package cn.gov.gzst.assessment.controller;



import cn.gov.gzst.assessment.entity.EvalProcess;
import cn.gov.gzst.assessment.entity.EvalProcesslast;
import cn.gov.gzst.assessment.entity.Evaluation;
import cn.gov.gzst.assessment.entity.EvalSelfResult;
import cn.gov.gzst.assessment.service.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mrlong
 * @since 2019-04-12
 */
@Api(value="科技项目评价表-",tags={"科技项目评价表-----"})
@Controller
@RequestMapping("jxpgEvaluation")
public class EvaluationController extends BaseBeanController<Evaluation> {
    @Autowired
    private IEvaluationService iEvaluationService;
    @Autowired
    private IEvalSelfResultService iEvalSelfResultService;
    @Autowired
    private IEvalSelfStructureService iEvalSelfStructureService;
    @Autowired
    private IEvalProcessService iEvalProcessService;
    @Autowired
    private IEvalProcesslastService iEvalProcesslastService;


    @GetMapping("getString")
    @ResponseBody
    public String getString(){
        return "gdfsdedsdfds";
    }


    @ApiOperation("查看信息：科技报告-项目信息-经费预算-自评表-评价表")
    @GetMapping("{pactid}/getReportAllInfo")
    @ResponseBody
    public Map  getReportBaseInfo(@PathVariable("pactid") String pactid) {

        Map Allevalpformance = new HashMap();
        Map base = new HashMap();
        List selftable = new ArrayList();
        Map evaltable = new HashMap();
        base = iEvaluationService.getReportBaseInfo(pactid);
        evaltable = iEvaluationService.getEvalInfo(pactid);


        selftable = iEvalSelfResultService.userFindDetail(pactid);
        if (selftable==null||selftable.isEmpty()){
            selftable= iEvalSelfStructureService.findAllStrInfo();
        }
        Allevalpformance.put("base",base);
        Allevalpformance.put("evaltable",evaltable);
        Allevalpformance.put("selftable",selftable);

        return Allevalpformance;
    }



    //创建
    @PostMapping("saveReportAllInfo")
    @ApiOperation("保存信息：科技报告-项目信息-经费预算-自评表-评价表-")
    @ResponseBody
    public ResponseResult saveReportBaseInfo(Evaluation entity, BindingResult result,
                                             HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();


        //获取前台传递的数据
        String datalist = request.getParameter("data");
        String pactid = request.getParameter("p1");
         //保存评价表的内容-采用自动封装原理
        entity.setPactid(pactid);
        entity.setSubmitdate(new Date());
        iEvaluationService.saveOrUpdate(entity);



        //循环遍历自评表的数据保存或更新数据库内容
        JSONArray jsonArray = JSONArray.parseArray(datalist);
        if(jsonArray.size()>0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                EvalSelfResult entity1 = new EvalSelfResult();

                String third_id = json.getString("third_id");
                String selfid = json.getString("selfid");
                String grade = json.getString("grade");

                entity1.setId(selfid);
                entity1.setThirdclassid(third_id);
                entity1.setGrade(grade);
                entity1.setPactid(pactid);
                entity1.setFilltime(new Date());
                iEvalSelfResultService.saveOrUpdate(entity1);
            }
        }
        EvalProcess evalProcess = new EvalProcess();
        evalProcess.setState(2);
        evalProcess.setPactid(pactid);
        evalProcess.setOperateTime(new Date());
        evalProcess.setOpinion("已提交");
        iEvalProcessService.saveOrUpdate(evalProcess);

        EvalProcesslast evalProcesslast = new EvalProcesslast();
        evalProcesslast.setState(2);
        evalProcesslast.setPactid(pactid);
        evalProcesslast.setOperateTime(new Date());
        evalProcesslast.setOpinion("已提交");
        evalProcesslast.setOperator("当前用户！");
        evalProcesslast.setIscheck(0);
        iEvalProcesslastService.insertOrUpdate(evalProcesslast);


        return  responseResult.ok("保存成功");
    }

    /**
     * 获得应用程序配置
     * @param id
     * @return
    */
    @ApiOperation("根据id查询相关记录")
    @GetMapping("{id}/findById")
    @ResponseBody
    public Evaluation findById(@PathVariable("id") String id){
        return iEvaluationService.findById(id);
    }



}
