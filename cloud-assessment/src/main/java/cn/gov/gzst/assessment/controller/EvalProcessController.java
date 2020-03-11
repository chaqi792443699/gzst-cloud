package cn.gov.gzst.assessment.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.assessment.entity.EvalProcess;
import cn.gov.gzst.assessment.service.IEvalProcessService;
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
 * @author longwanyuan
 * @since 2019-04-26
 */
@RestController
@RequestMapping("eval-process")
public class EvalProcessController extends BaseBeanController<EvalProcess> {
    @Autowired
    private IEvalProcessService evalProcessService;


    /**
     * 获得应用程序配置
     * @param pactid
     * @return
     */
    @ApiOperation("管理员查看已审核列表的审批记录---------")
    @GetMapping("{pactid}/adminFindApprovalRecord")
    public  List<EvalProcess> adminFindApprovalRecord(@PathVariable("pactid") String pactid){
        return evalProcessService.adminFindApprovalRecord(pactid);
    }



    @ApiOperation("用户查看填写列表的审批记录---------")
    @GetMapping("{pactid}/findRecord")
    public List<EvalProcess> findRecord(@PathVariable("pactid") String pactid) {
        return evalProcessService.findRecord(pactid);
    }
}
