package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.FinanceExpenditure;
import cn.gov.gzst.assessment.service.FinanceExpenditureService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
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

import org.springframework.stereotype.Controller;
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.util.UUID;

/**
 * <p>
 * 实际支出接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Api(value = "实际支出接口", tags = "实际支出接口")
@Controller
@RequestMapping("cwpg-expenditure")
public class FinanceExpenditureController extends BaseBeanController<FinanceExpenditure> {
    @Autowired
    private FinanceExpenditureService cwpgExpenditureService;


    /* *//**
     * 查询合同预算信息
     * @param contract_id 合同预算编号
     * @param page        当前第几页
     * @param limit       每页显示的条数
     * @param request
     * @param response
     *//*
    @GetMapping("list")
    @ApiOperation(value = "查询合同预算信息",notes = "查询合同预算信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id",value = "合同预算编号",dataType = "String",required = false,paramType = "query"),
            @ApiImplicitParam(name = "page",value = "当前第几页",dataType = "int",required = true,paramType = "query"),
            @ApiImplicitParam(name = "limit",value = "每页显示的条数",dataType = "int",required = true,paramType = "query")
    })
    public void ajaxList(String contract_id,Integer page,Integer limit, HttpServletRequest request,
    HttpServletResponse response){
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<FinanceExpenditure> entityWrapper = new EntityWrapper<>(FinanceExpenditure.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("contractId",keywords);


                entityWrapper.or().like("costId",keywords);


                entityWrapper.or().like("expenditureZc",keywords);


                entityWrapper.or().like("expenditureZx",keywords);


                entityWrapper.or().like("description",keywords);


        }
        entityWrapper.eq("CONTRACT_ID", contract_id);
        pageBean= cwpgExpenditureService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,contractId,costId,expenditureZc,expenditureZx,description");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
     }*/

    /**
     * 获得应用程序配置
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public FinanceExpenditure find(@PathVariable("id") String id) {
        return cwpgExpenditureService.selectById(id);
    }

    //创建
    @PostMapping("create")
    public ResponseResult create(FinanceExpenditure entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        String cost = request.getParameter("cost");
        JSONArray array = JSONArray.parseArray(cost);
        if (array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(i);
                FinanceExpenditure expenditure = new FinanceExpenditure();
                expenditure.setId(UUID.randomUUID().toString());
                expenditure.setCostId(object.getString("costNumber"));
                expenditure.setExpenditureZc(object.getBigDecimal("expenditureZc"));
                expenditure.setExpenditureZx(object.getBigDecimal("expenditureZx"));
                expenditure.setDescription(object.getString("Description"));
                doSave(entity, request, response, result);
            }
        }
        return null;
    }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(FinanceExpenditure entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //保存
    @PostMapping("/save")
    public ResponseResult doSave(FinanceExpenditure entity, HttpServletRequest request,
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
                cwpgExpenditureService.insert(entity);
            } else {
                cwpgExpenditureService.insertOrUpdate(entity);
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
            cwpgExpenditureService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }
}
