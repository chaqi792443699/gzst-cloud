package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.FinanceProblem;
import cn.gov.gzst.assessment.service.FinanceProjectExtractService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.assessment.service.FinanceProblemService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 问题信息接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Api(value = "问题信息接口", tags = "问题信息接口")
@RestController
@RequestMapping("cwpg-problem")
public class FinanceProblemController extends BaseBeanController<FinanceProblem> {
    @Autowired
    private FinanceProblemService cwpgProblemService;
    @Autowired
    private FinanceProjectExtractService projectExtractService;


    /**
     * 根据项目编号查询问题列表
     * @return
     */
    @GetMapping("selectProblemList")
    @ApiOperation(value = "根据项目编号查询问题列表")
    public Object selectProblemList(String projectId, HttpServletRequest request,
                                    HttpServletResponse response) {
        List<FinanceProblem> problems = cwpgProblemService.selectProblemList(projectId);
        return problems;
    }

    /**
     * 获得应用程序配置
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public FinanceProblem find(@PathVariable("id") String id) {
        return cwpgProblemService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(FinanceProblem entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {

        return doSave(entity, request, response, result);
    }

    //修改
    @PostMapping("/update")
    public ResponseResult update(FinanceProblem entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        String projectId = request.getParameter("projectId");
        String opinion = request.getParameter("question");
        JSONArray jsonArray = JSONArray.parseArray(opinion);
        if (jsonArray.size() > 0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Map<String, Object> map = new HashMap<>();
                map.put("opinion", object.getString("opinion"));
                map.put("problemContent", object.getString("problemContent"));
                map.put("projectId", projectId);
                cwpgProblemService.problemUpdate(map);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("status", "4");
            map.put("projectId", entity.getProjectId());
            boolean b = projectExtractService.updateByProjectId(map);
            if(b == true){
                responseResult.ok("保存成功！");
            }else {
                responseResult.ok("保存失败！");
                return responseResult;
            }
        }
        return  responseResult;
    }

    //保存
    @PostMapping("/save")
    public ResponseResult doSave(FinanceProblem entity, HttpServletRequest request,
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
            cwpgProblemService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }
}
