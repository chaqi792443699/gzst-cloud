package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.FinanceProcess;
import cn.gov.gzst.assessment.service.FinanceProcessService;
import cn.gov.gzst.assessment.service.IPactProjectbaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.assessment.entity.PgzxProcesslsat;
import cn.gov.gzst.assessment.service.IPgzxProcesslsatService;
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
import java.util.Map;

/**
 * <p>
 * 审核记录表 前端控制器
 * </p>
 *
 * @author longwanyuan
 * @since 2019-05-23
 */
@RestController
@RequestMapping("pgzxprocesslsat")
public class PgzxProcesslsatController extends BaseBeanController<FinanceProcess> {
    @Autowired
    private IPgzxProcesslsatService pgzxProcesslsatService;
    @Autowired
    private FinanceProcessService processService;
    @Autowired
    private IPactProjectbaseService projectbaseService;


  /*  *//**
    * 查找列表
    * @param page
     * @param limit
    * @return
    */
    @GetMapping("list")
    public Object ajaxList(String pactid,@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "limit",required = false) Integer limit, HttpServletRequest request,
    HttpServletResponse response){
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<FinanceProcess> entityWrapper = new EntityWrapper<>(FinanceProcess.class);
        if(!StringUtils.isEmpty(pactid)){
            entityWrapper.eq("PACTID",pactid);
        }
        pageBean= processService.selectPage(pageBean,entityWrapper);
        if(pageBean.getRecords().size()>0) {
            List<FinanceProcess> list = pageBean.getRecords();
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (!StringUtils.isEmpty(list.get(i).getApprovalId())) {
                        Map<String, Object> map = projectbaseService.selectUser(list.get(i).getApprovalId());
                        if (!StringUtils.isEmpty(map.get("NAME") + "")) {
                            list.get(i).setApprovalId(map.get("NAME").toString());
                        }
                    }
                }
            }
            pageBean.setRecords(list);
        }
        return pageBean;
     }




    /**
     * 保存审批记录
     * @param entity
     * @param result
     * @param request
     * @param response
     * @return
     */
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(FinanceProcess entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        boolean insert = processService.insert(entity);
        if(insert == true){
            responseResult.ok("审批成功！");
        }else {
            responseResult.ok("审批失败！");
        }
        return responseResult;
     }

}
