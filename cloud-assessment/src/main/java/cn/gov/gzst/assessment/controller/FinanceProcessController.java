package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.assessment.entity.FinanceProblem;
import cn.gov.gzst.assessment.entity.FinanceProcess;
import cn.gov.gzst.assessment.service.FinanceConclusionService;
import cn.gov.gzst.assessment.service.FinanceProblemService;
import cn.gov.gzst.assessment.service.FinanceProcessService;
import cn.gov.gzst.assessment.service.FinanceProjectExtractService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gov.gzst.common.common.controller.BaseBeanController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 审批流程接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Api(value = "审批流程接口", tags = "审批流程接口")
@RestController
@RequestMapping("cwpg-process")
public class FinanceProcessController extends BaseBeanController<FinanceProcess> {
    @Autowired
    private FinanceProcessService cwpgProcessService;
    @Autowired
    private FinanceProjectExtractService projectExtractService;
    @Autowired
    private FinanceProblemService problemService;
    @Autowired
    private FinanceConclusionService conclusionService;

    @ResponseBody
    @RequestMapping(value = "selectProcessById", method = RequestMethod.GET)
    @ApiOperation(value = "查询审批流程信息")
    @ApiImplicitParam(name = "projectId", value = "项目编号", dataType = "String", required = true, paramType = "query")
    public Object selectProcessById(String projectId, HttpServletRequest req, HttpServletResponse resp) {
        return cwpgProcessService.selectProcessById(projectId);
    }

    /**
     * 保存审批信息
     *
     * @param entity   审批信息对象
     * @param request
     * @param response
     * @param result
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存审批信息")
    public ResponseResult doSave(FinanceProcess entity, HttpServletRequest request,
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
                String userid = request.getParameter("userid");
                String projectId = request.getParameter("projectId");
                String opinion = request.getParameter("question");
                entity.setApprovalTime(new Date());
                entity.setApprovalId(userid);
                //根据项目编号查询最新的审核记录
                FinanceProcess financeProcess = cwpgProcessService.selectProcessByProjectId(projectId);
                //根据项目编号查询评估结论
                FinanceConclusion financeConclusion = conclusionService.selectConclusionByProjectId(projectId);
                if(financeProcess.getApproval().equals("2")){
                   financeConclusion.setReviewId(userid);
                   financeConclusion.setReviewOpinion(entity.getApprovalOpinion());
                   financeConclusion.setReviewTime(new Date());
                   conclusionService.updateById(financeConclusion);
                }
                JSONArray jsonArray = JSONArray.parseArray(opinion);
                if (cwpgProcessService.insert(entity) == true) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", entity.getApproval());
                    map.put("projectId", entity.getProjectId());
                    projectExtractService.updateByProjectId(map);
                }
                FinanceProblem problem = null;
                List<FinanceProblem> financeProblems = problemService.selectProblemList(projectId);
                for (int i = 0; i < financeProblems.size() - 1; i++) {
                    for (int j = 0; j < financeProblems.size() - 1 - i; j++) {
                        if (financeProblems.get(j).getSort() > financeProblems.get(j + 1).getSort()) {
                            int num = financeProblems.get(j).getSort();
                            financeProblems.get(j).setSort(financeProblems.get(j + 1).getSort());
                            financeProblems.get(j + 1).setSort(num);
                        }
                    }
                }
                int num = financeProblems.get(financeProblems.size() - 1).getSort();
                if (financeProblems == null) {
                    if (jsonArray.size() > 0) {
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            problem = new FinanceProblem();
                            problem.setSort(i + 1);
                            problem.setProjectId(projectId);
                            problem.setOpinion(object.getString("opinion"));
                            problem.setProblemContent(object.getString("problemContent"));
                            problemService.insert(problem);
                        }
                    }
                } else {
                    if (jsonArray.size() > 0) {
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            problem = new FinanceProblem();
                            problem.setSort(num + i + 1);
                            problem.setProjectId(projectId);
                            problem.setOpinion(object.getString("opinion"));
                            problem.setProblemContent(object.getString("problemContent"));
                            problemService.insert(problem);
                        }
                    }
                }
            } else {
                cwpgProcessService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }
}
