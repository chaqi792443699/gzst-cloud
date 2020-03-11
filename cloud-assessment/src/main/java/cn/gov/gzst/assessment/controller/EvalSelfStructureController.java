package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.EvalSelfStructure;
import cn.gov.gzst.assessment.service.IEvalSelfStructureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lonwanyuan
 * @since 2019-04-19
 */
@Api(tags={"自评表结构--"})
@Controller
@RequestMapping("jxpgSelf")
public class EvalSelfStructureController extends BaseBeanController<EvalSelfStructure> {
    @Autowired
    private IEvalSelfStructureService iEvalSelfStructureService;


    /**
     * 获得表结构信息
     *
     * @param
     * @return
     */
    @ApiOperation("获得表结构信息-1,2,3级指标及其评价内容，分值，评分标准，得分")
    @GetMapping("findAllStrInfo")
    @ResponseBody
    public List<Map<String, Object>> findAllStrInfo() {
        return iEvalSelfStructureService.findAllStrInfo();
    }

}


