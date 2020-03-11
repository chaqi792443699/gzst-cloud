package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.assessment.entity.FinanceProjectExtract;
import cn.gov.gzst.assessment.entity.PactProjectbase;
import cn.gov.gzst.assessment.service.FinanceConclusionService;
import cn.gov.gzst.assessment.service.FinanceProjectExtractService;
import cn.gov.gzst.assessment.service.IPactProjectbaseService;
import cn.gov.gzst.pms.feign.PactProjectBaseFeign;
import cn.gov.gzst.pms.feign.PmsDepartmentFeign;
import com.baomidou.kisso.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 抽取项目接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Api(value = "抽取项目接口", tags = "抽取项目接口")
@RestController
@RequestMapping("cwpg-project-extract")
public class FinanceProjectExtractController extends BaseBeanController<FinanceProjectExtract> {
    @Autowired
    private FinanceProjectExtractService cwpgProjectExtractService;
    @Autowired
    private IPactProjectbaseService projectbaseService;
    @Autowired
    private FinanceConclusionService conclusionService;

    /**
     * 已抽取项目列表
     * @param page     当前第几页
     * @param limit    每页显示的条数
     * @param request
     * @param response
     */
    @Permission("Extracted_item_list")
    @ApiOperation(value = "已抽取项目列表")
    @GetMapping("list")
    public Object ajaxList(String status, String extractBatch, Integer page, Integer limit, HttpServletRequest request,
                           HttpServletResponse response) {
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        FinanceProjectExtract financeProjectExtract = cwpgProjectExtractService.selectRecentBatch();
        if (StringUtils.isEmpty(extractBatch)) {
            extractBatch = financeProjectExtract.getExtractBatch();
        }
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        //根据抽取的时间进行排序
        entityWrapper.orderDesc(Collections.singleton("pc.EXTRACT_TIME"));
        if (!StringUtils.isEmpty(status)) {
            //加入条件，根据状态查询项目信息
            entityWrapper.eq("pc.STATUS", status);
        }
        if (!StringUtils.isEmpty(extractBatch)) {
            entityWrapper.eq("pc.EXTRACT_BATCH", extractBatch);
        }
        pageBean = projectbaseService.selectProject(pageBean, entityWrapper);
        List<Map<String,Object>> projectExtracts = pageBean.getRecords();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < projectExtracts.size(); i++) {
            Map<String, Object> map = projectExtracts.get(i);
            Map<String, Object> resultMap = new HashMap<>();
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap.put(newKey, map.get(key));
            }
            resultMap.put("extractBatch",resultMap.get("extractbatch"));
            resultMap.put("projectId", resultMap.get("id"));
            resultMap.put("status", resultMap.get("status"));
            list.add(resultMap);
        }
        return pageBean.setRecords(list);
    }

    /**
     * 随机抽取项目
     */
    @ApiOperation(value = "随机抽取项目")
    @GetMapping("selectList")
    public Object selectList(@RequestParam(value = "keywords", required = false) String keywords,
                             @RequestParam(value = "applydate", required = false) String applydate,
                             @RequestParam(value = "planno", required = false) String planno,
                             @RequestParam(value = "casemanagementcode", required = false) String casemanagementcode,
                             @RequestParam(value = "belonglab", required = false) String belonglab,
                             @RequestParam(value = "pactStatus", required = false) String pactStatus,
                             @RequestParam(value = "minMoney", required = false) String minMoney,
                             @RequestParam(value = "maxMoney", required = false) String maxMoney) {
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        if (!StringUtils.isEmpty(keywords)) {
            entityWrapper.like("pb.pactno", keywords);
            entityWrapper.or().like("ppb.projectbasename", keywords);
        }
        if (!StringUtils.isEmpty(applydate)) {
            entityWrapper.and("to_char(applydate,'yyyy')like '"+applydate+"'");
        }
        if (!StringUtils.isEmpty(planno)) {
            entityWrapper.eq("pppb.applicationtypecode1", planno);
        }
        if (!StringUtils.isEmpty(casemanagementcode)) {
            entityWrapper.eq("ppb.projectplantypecode", casemanagementcode);
        }
        if (!StringUtils.isEmpty(belonglab)) {
            entityWrapper.eq("ppb.belonglab", belonglab);
        }
        if(!StringUtils.isEmpty(pactStatus)){
            if("3".equals(pactStatus)){
                entityWrapper.isNull("ps.status");
            }else {
                entityWrapper.eq("ps.status",pactStatus);
            }
        }
        if(!StringUtils.isEmpty(minMoney)){
            entityWrapper.between("pe.jhxtzkjjf",minMoney,maxMoney);
        }
        int count = projectbaseService.selectCount(entityWrapper);
        //获取要抽取的项目条数
        int randomNumber = (int) Math.ceil((count * 0.05) * 0.05);
        Page pageBean = new Page(1,randomNumber);
        Page<Map<String,Object>> page = projectbaseService.selectList(pageBean, entityWrapper);
        List<Map<String,Object>> list = page.getRecords();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Map<String, Object> resultMap = new HashMap<>();
            Set<String> keySet = map.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap.put(newKey, map.get(key));
            }
            list1.add(resultMap);
        }
        return list1;
    }

    /**
     * 获得应用程序配置
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public FinanceProjectExtract find(@PathVariable("id") String id) {
        return cwpgProjectExtractService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(FinanceProjectExtract entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult= new ResponseResult();
        String str = request.getParameter("projectId");
        String extractBatch = request.getParameter("extractBatch");
        String[] arr = str.split(",");
        int num = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            FinanceProjectExtract projectExtract = cwpgProjectExtractService.selectProjectByProjectId(arr[i]);
            FinanceProjectExtract financeProjectExtract = new FinanceProjectExtract();
            if (projectExtract == null) {
                financeProjectExtract.setProjectId(arr[i]);
                financeProjectExtract.setExtractId(request.getParameter("userid"));
                financeProjectExtract.setExtractBatch(extractBatch);
                financeProjectExtract.setExtractTime(new Date());
                financeProjectExtract.setStatus("0");
                boolean insert = cwpgProjectExtractService.insert(financeProjectExtract);
                //抽取的项目保存成功后创建评估结论
                if(insert==true) {
                    num = num +1;
                    FinanceConclusion conclusion = new FinanceConclusion();
                    conclusion.setConclusionStatus("0");
                    conclusion.setCreateTime(new Date());
                    conclusion.setProjectId(arr[i]);
                    conclusion.setPreparedId(request.getParameter("userid"));
                    conclusionService.insert(conclusion);
                }
            }else {
                count = count +1 ;
            }
        }
        if(count == 0){
            responseResult.ok("成功抽取"+num+"个项目!");
        }else {
            responseResult.ok("成功抽取" + num + "个项目,有" + count + "个项目已经被抽取过了！");
        }
        return responseResult;
    }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(FinanceProjectExtract entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //保存
    @PostMapping("/save")
    public ResponseResult doSave(FinanceProjectExtract entity, HttpServletRequest request,
                                 HttpServletResponse response, BindingResult result) {
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
                cwpgProjectExtractService.insert(entity);
            } else {
                cwpgProjectExtractService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    //删除
    @GetMapping("{id}/delete")
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            cwpgProjectExtractService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }

    /**
     * 根据项目编号查询项目信息和合同信息
     * @param projectId 项目编号
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping(value = "selectProjectAndContract", method = RequestMethod.GET)
    @ApiOperation(value = "根据项目编号查询项目信息和合同信息")
    @ApiImplicitParam(name = "projectId", value = "项目编号", dataType = "String", required = true, paramType = "query")
    public Object selectProjectAndContract(String projectId, HttpServletRequest req, HttpServletResponse resp) {
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        entityWrapper.eq("ppb.id", projectId);
        Map<String, Object> map = projectbaseService.selectProjectAndContract(entityWrapper);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = date.format(map.get("PROJECTSTARTDATE"));
        String endDate = date.format(map.get("PROJECTENDDATE"));
        map.put("PROJECTSTARTDATE", startDate);
        map.put("PROJECTENDDATE", endDate);
        map.put("projectId", projectId);
        Map<String, Object> resultMap = new HashMap<>();
        Set<String> keySet = map.keySet();
        //将Map集合里面的Key转化为小写
        for (String key : keySet) {
            String newKey = key.toLowerCase();
            newKey = newKey.replace("_", "");
            resultMap.put(newKey, map.get(key));
        }
        return resultMap;
    }

    /**
     * 根据登录人查询项目信息
     * @param page           当前第几页
     * @param limit          每页显示的条数
     * @return
     */
    @RequestMapping(value = "selectProjectByUser", method = RequestMethod.GET)
    @ApiOperation(value = "根据登陆的项目负责人查询项目信息")
    public Object selectProjectByUser(Integer page, Integer limit) {
        String declarantid = request.getParameter("declarantid");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        entityWrapper.eq("ppb.declarantid", declarantid);
        Page<Map<String, Object>> pageList = projectbaseService.selectProjectByDeclarantId(pageBean,entityWrapper);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < pageList.getRecords().size(); i++) {
                FinanceProjectExtract financeProjectExtract=cwpgProjectExtractService.selectProjectByProjectId(pageList.getRecords().get(i).get("ID")+"");
                Map<String, Object> map = pageList.getRecords().get(i);
                Map<String, Object> resultMap = new HashMap<>();
                Set<String> keySet = map.keySet();
                //将Map集合里面的Key转化为小写
                for (String key : keySet) {
                    String newKey = key.toLowerCase();
                    newKey = newKey.replace("_", "");
                    resultMap.put(newKey, map.get(key));
                }
                resultMap.put("projectId", financeProjectExtract.getProjectId());
                resultMap.put("status", financeProjectExtract.getStatus());
                list.add(resultMap);
                int count = i + 1;
                pageList.setTotal(count);
        }
        pageList.setRecords(list);
        return pageList;
    }

    /**
     * 查询已审核的项目
     * @param page          当前第几页
     * @param limit         每页显示的条数
     * @param extractBatch  项目抽取批次
     * @param request
     * @param response
     * @return
     */
    @Permission("reviewed_project_information")
    @RequestMapping(value = "selectProjectStatus", method = RequestMethod.GET)
    @ApiOperation(value = "获取已审核的项目信息")
    public Object selectProjectStatus(Integer page, Integer limit, String extractBatch, HttpServletRequest request,
                                      HttpServletResponse response) {
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        entityWrapper.eq("pc.STATUS", "1").or().eq("pc.STATUS", "3");
        pageBean = projectbaseService.selectProject(pageBean, entityWrapper);
        List<Map<String,Object>> list = pageBean.getRecords();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Map<String, Object> resultMap = new HashMap<>();
            Set<String> keySet = map.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap.put(newKey, map.get(key));
            }
            resultMap.put("projectId",resultMap.get("id"));
            resultMap.put("status", resultMap.get("status"));
            list1.add(resultMap);
        }
        pageBean.setRecords(list1);
        return pageBean;
    }

    /**
     * 查询需要审核的项目
     * @param page            当前第几页
     * @param limit           每页显示的条数
     * @param extractBatch    项目抽取批次
     * @param request
     * @param response
     * @return
     */
    @Permission("Need_reviewed")
    @RequestMapping(value = "selectProjectReview", method = RequestMethod.GET)
    @ApiOperation(value = "获取需要审核的项目信息")
    public Object selectProjectReview(Integer page, Integer limit, String extractBatch, HttpServletRequest request,
                                      HttpServletResponse response) {
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        entityWrapper.eq("pc.STATUS", "4");
        pageBean = projectbaseService.selectProject(pageBean, entityWrapper);
        List<Map<String,Object>> list = pageBean.getRecords();
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Map<String, Object> resultMap = new HashMap<>();
            Set<String> keySet = map.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap.put(newKey, map.get(key));
            }
            resultMap.put("projectId", resultMap.get("id"));
            resultMap.put("status", resultMap.get("status"));
            list1.add(resultMap);
        }
        pageBean.setRecords(list1);
        return pageBean;
    }

    /**
     * 查询项目抽取批次
     *
     * @return
     */
    @GetMapping(value = "/selectBatch")
    @ApiOperation(value = "查询项目抽取批次")
    public Object selectBatch() {
        List<FinanceProjectExtract> projectExtracts = cwpgProjectExtractService.selectExtractBatch();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<projectExtracts.size();i++){
            Map<String,Object> map= new HashMap<>();
            String extractTime =format.format(projectExtracts.get(i).getExtractTime());
            String extractBatch = projectExtracts.get(i).getExtractBatch();
            map.put("value","第"+extractBatch+"批次");
            map.put("extractBatch",extractBatch);
            list.add(map);
        }
        return list;
    }

    /**
     * 查看合同状态
     * @return
     */
    @GetMapping(value = "/sectelContractStatus")
    @ApiOperation(value = "查询合同状态")
    public Object selectContractStatus() {
        List<Map<String, Object>> list = projectbaseService.selectStatus();
        Map<String, Object> map = new HashMap<>();
        map.put("STATUS", "3");
        list.add(map);
        Map<String,Object> map1 = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i).get("STATUS").toString();
            switch (key) {
                case "1":
                    map1.put(key, "已验收");
                    break;
                case "2":
                    map1.put(key, "已结题");
                    break;
                default:
                    map1.put(key,"未验收");
                     break;
            }
        }
        return map1;
    }

}
