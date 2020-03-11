package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.FinanceContractBudget;
import cn.gov.gzst.assessment.entity.FinanceProjectExtract;
import cn.gov.gzst.assessment.service.FinanceContractBudgetService;
import cn.gov.gzst.assessment.service.FinanceProjectExtractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 合同预算信息接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-24
 */
@Api(value = "合同预算信息借口", tags = "合同预算信息接口")
@Controller
@RequestMapping("finance-contract-budget")
public class FinanceContractBudgetController extends BaseBeanController<FinanceContractBudget> {
    @Autowired
    private FinanceContractBudgetService financeContractBudgetService;
    @Autowired
    private FinanceProjectExtractService projectExtract;


    /**
     * 根据项目编号查询合同预算信息
     *
     * @param projectId 项目编号
     * @param request
     * @param response
     */
    @GetMapping("list")
    @ApiOperation(value = "根据项目编号查询合同预算信息")
    @ApiImplicitParam(name = "projectId", value = "项目编号", dataType = "String", required = true, paramType = "query")
    public void contractBudgetByProjectId(String projectId, HttpServletRequest request,
                                          HttpServletResponse response) {
        EntityWrapper<FinanceContractBudget> entityWrapper = new EntityWrapper<>(FinanceContractBudget.class);
        entityWrapper.eq("projectid", projectId);
        FinanceContractBudget cwpgContractBudget = financeContractBudgetService.contractBudgetByProjectId(entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter("id,contractid,projectid,createtime,updatetime,instrumentexpenditurezc,materialexpenditurezc,testexpenditurezc,fuelexpenditurezc,meetingenditurezc,publishingexpenditurezc,labourservicesexpenditurezc, expertexpenditurezc,otherexpenditurezc,indirectexpenditurezc,instrumentexpenditurezx,materialexpenditurezx,testexpenditurezx,fuelexpenditurezx,meetingenditurezx,publishingexpenditurezx,labourservicesexpenditurezx,expertexpenditurezx,otherexpenditurezx,indirectexpenditurezx,totalzc,totalzx,contracttype,instrumentreason,materialreason,testreason,fuelreason,meetingreason,publishingreason,labourservicesreason,expertconsultationreason,otherreason,indirectreason,instrumentreasonzx,materialreasonzx,testreasonzx,fuelreasonzx,meetingreasonzx,publishingreasonzx,labourservicesreasonzx,expertconsultationreasonzx,otherreasonzx,indirectreasonzx");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(cwpgContractBudget, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 获得应用程序配置
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public FinanceContractBudget find(@PathVariable("id") String id) {
        return financeContractBudgetService.selectById(id);
    }


    //创建
    @PostMapping("contractSave")
    public ResponseResult contractSave(FinanceContractBudget entity, BindingResult result,
                                       HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(FinanceContractBudget entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //保存
    @PostMapping("/save")
    public ResponseResult doSave(FinanceContractBudget entity, HttpServletRequest request,
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
            EntityWrapper<FinanceContractBudget> entityWrapper = new EntityWrapper<>(FinanceContractBudget.class);
            entityWrapper.eq("projectid", entity.getProjectid());
            FinanceContractBudget contractBudget = financeContractBudgetService.contractBudgetByProjectId(entityWrapper);
            Map<String,Object> map = new HashMap<>();
            if (contractBudget == null) {
                entity.setCreatetime(new Date());
                boolean insert = financeContractBudgetService.insert(entity);
                if(insert == true){
                    map.put("status","4");
                    map.put("projectId",entity.getProjectid());
                    projectExtract.updateByProjectId(map);
                }
            } else {
                entity.setUpdatetime(new Date());
                entity.setId(contractBudget.getId());
                boolean b = financeContractBudgetService.updateById(entity);
                if(b == true){
                    map.put("status","4");
                    map.put("projectId",entity.getProjectid());
                    projectExtract.updateByProjectId(map);
                }
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
            financeContractBudgetService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }
}
