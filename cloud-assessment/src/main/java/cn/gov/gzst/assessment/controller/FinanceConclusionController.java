package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.assessment.service.FinanceConclusionService;
import cn.gov.gzst.assessment.service.FinanceProblemService;
import cn.gov.gzst.assessment.service.IPactProjectbaseService;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p>
 * 评估结论接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Api(value = "评估结论接口", tags = "评估结论接口")
@RestController
@RequestMapping("cwpg-conclusion")
public class FinanceConclusionController extends BaseBeanController<FinanceConclusion> {
    @Autowired
    private FinanceConclusionService cwpgConclusionService;

    /**
     * 查询评估结论
     *
     * @param projectId 项目编号
     * @param request
     * @param response
     */
    @GetMapping("list")
    @ApiOperation(value = "查询评估结论信息")
    @ApiImplicitParam(name = "projectId", value = "项目编号", dataType = "String", required = true, paramType = "query")
    public Object ajaxList(@RequestParam("projectId") String projectId, HttpServletRequest request,
                           HttpServletResponse response) {
        EntityWrapper<FinanceConclusion> entityWrapper = new EntityWrapper<>(FinanceConclusion.class);
        entityWrapper.eq("c.PROJECT_ID", projectId);
        List<Map<String,Object>> conclusion = cwpgConclusionService.selectConclusionList(entityWrapper);
        FinanceConclusion financeConclusion = cwpgConclusionService.selectConclusionByProjectId(projectId);
       // PactProjectbase projectbase = projectbaseService.selectProjectByDeclarantId(financeConclusion.getPreparedId());
        Map<String, Object> map = new HashMap<>();
        List<Map<String,Object>> list1 = new ArrayList<>();
        for(int i=0;i<conclusion.size();i++){
            Map<String,Object> objectMap=conclusion.get(i);
            Map<String, Object> resultMap = new HashMap<>();
            Set<String> keySet = objectMap.keySet();
            //将Map集合里面的Key转化为小写
            for (String key : keySet) {
                String newKey = key.toLowerCase();
                newKey = newKey.replace("_", "");
                resultMap.put(newKey, objectMap.get(key));
            }
            list1.add(resultMap);
        }
        String basicSituation = list1.get(0).get("basicsituation")+"";
        map.put("basicSituation", basicSituation);
        map.put("reviewOpinion", list1.get(0).get("reviewopinion"));
        //map.put("people", projectbase.getProjectleader());
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = null;
            for (int i = 0; i < list1.size(); i++) {
                map1 = new HashMap<>();
                map1.put("problemContent", list1.get(i).get("problemcontent"));
                map1.put("opinion", list1.get(i).get("opinion"));
                list.add(map1);
                map.put("question", list);
            }
        return map;
    }

    /**
     * 获得应用程序配置
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public FinanceConclusion find(@PathVariable("id") String id) {
        return cwpgConclusionService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(FinanceConclusion entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        FinanceConclusion conclusion = cwpgConclusionService.selectConclusionByProjectId(entity.getProjectId());

        return doSave(conclusion, request, response, result);
    }


    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(FinanceConclusion entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //保存
    @PostMapping("/save")
    public ResponseResult doSave(FinanceConclusion entity, HttpServletRequest request,
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
                cwpgConclusionService.insert(entity);
            } else {
                cwpgConclusionService.updateById(entity);
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
            cwpgConclusionService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }
}
