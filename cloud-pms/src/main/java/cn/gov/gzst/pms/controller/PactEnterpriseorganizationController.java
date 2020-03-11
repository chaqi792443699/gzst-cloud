package cn.gov.gzst.pms.controller;


import cn.gov.gzst.pms.entity.PactEnterpriseorganization;
import cn.gov.gzst.pms.service.IPactEnterpriseorganizationService;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@Controller
@RequestMapping("pactEnterpriseorganization")
public class PactEnterpriseorganizationController extends BaseBeanController<PactEnterpriseorganization> {
    @Autowired
    private IPactEnterpriseorganizationService pactEnterpriseorganizationService;

    /**
    * 查找列表
    * @param page
     * @param limit
    * @return
    */
    @GetMapping("list")
    public void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
    HttpServletResponse response){
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<PactEnterpriseorganization> entityWrapper = new EntityWrapper<>(PactEnterpriseorganization.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("organizationname",keywords);


                entityWrapper.or().like("organizationsimplename",keywords);


                entityWrapper.or().like("organizationtype",keywords);


                entityWrapper.or().like("legalcode",keywords);


                entityWrapper.or().like("addresscode",keywords);


                entityWrapper.or().like("managedepartment",keywords);


                entityWrapper.or().like("commintucateaddress",keywords);


                entityWrapper.or().like("postcard",keywords);


                entityWrapper.or().like("organizaitonemail",keywords);


                entityWrapper.or().like("organizationcontact",keywords);


                entityWrapper.or().like("organizationphone",keywords);


                entityWrapper.or().like("organizationfax",keywords);


                entityWrapper.or().like("banknumber",keywords);


                entityWrapper.or().like("enterpriseid",keywords);


                entityWrapper.or().like("projectbaseid",keywords);


                entityWrapper.or().like("dutyforproject",keywords);


                entityWrapper.or().like("ismainenterprise",keywords);


                entityWrapper.or().like("economiccategory",keywords);


                entityWrapper.or().like("enterprisescale",keywords);


                entityWrapper.or().like("technologyenterprises",keywords);


                entityWrapper.or().like("numberofstaff",keywords);


                entityWrapper.or().like("technicalpersonnel",keywords);


                entityWrapper.or().like("totalassets",keywords);


                entityWrapper.or().like("annualsales",keywords);


                entityWrapper.or().like("fundingforesearch",keywords);


                entityWrapper.or().like("newproductplan",keywords);


                entityWrapper.or().like("mobile",keywords);


                entityWrapper.or().like("enterprisetype",keywords);


                entityWrapper.or().like("organizationhead",keywords);


                entityWrapper.or().like("seq",keywords);


                entityWrapper.or().like("registerdate",keywords);


                entityWrapper.or().like("belongsvillage",keywords);


                entityWrapper.or().like("leadingproductname",keywords);


                entityWrapper.or().like("lastyearsales",keywords);


                entityWrapper.or().like("developmentfee",keywords);


                entityWrapper.or().like("contractstartdate",keywords);


                entityWrapper.or().like("contractenddate",keywords);


                entityWrapper.or().like("leader",keywords);


                entityWrapper.or().like("leadertel",keywords);


                entityWrapper.or().like("legalrepresentative",keywords);


                entityWrapper.or().like("annualsalesrevenue",keywords);


                entityWrapper.or().like("researchbase",keywords);


                entityWrapper.or().like("cooperation",keywords);


                entityWrapper.or().like("xmsbsid",keywords);


                entityWrapper.or().like("contactphone",keywords);


                entityWrapper.or().like("unitproperty",keywords);


                entityWrapper.or().like("legalmobilephone",keywords);


                entityWrapper.or().like("contactmobilphone",keywords);


                entityWrapper.or().like("starttime",keywords);


                entityWrapper.or().like("overtime",keywords);


                entityWrapper.or().like("application",keywords);


                entityWrapper.or().like("saleincome",keywords);


                entityWrapper.or().like("tax",keywords);


                entityWrapper.or().like("jxid",keywords);


                entityWrapper.or().like("startendtime",keywords);


                entityWrapper.or().like("yyfs",keywords);


                entityWrapper.or().like("promotionsituation",keywords);


                entityWrapper.or().like("accountbank",keywords);


                entityWrapper.or().like("pactid",keywords);


                entityWrapper.or().like("divisionwork",keywords);


                entityWrapper.or().like("totalexpenditure",keywords);


                entityWrapper.or().like("kjtexpenditure",keywords);


                entityWrapper.or().like("bankname",keywords);


                entityWrapper.or().like("bankacountname",keywords);


                entityWrapper.or().like("type",keywords);


        }
        pageBean= pactEnterpriseorganizationService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,organizationname,organizationsimplename,organizationtype,legalcode,addresscode,managedepartment,commintucateaddress,postcard,organizaitonemail,organizationcontact,organizationphone,organizationfax,banknumber,enterpriseid,projectbaseid,dutyforproject,ismainenterprise,economiccategory,enterprisescale,technologyenterprises,numberofstaff,technicalpersonnel,totalassets,annualsales,fundingforesearch,newproductplan,mobile,enterprisetype,organizationhead,seq,registerdate,belongsvillage,leadingproductname,lastyearsales,developmentfee,contractstartdate,contractenddate,leader,leadertel,legalrepresentative,annualsalesrevenue,researchbase,cooperation,xmsbsid,contactphone,unitproperty,legalmobilephone,contactmobilphone,starttime,overtime,application,saleincome,tax,jxid,startendtime,yyfs,promotionsituation,accountbank,pactid,divisionwork,totalexpenditure,kjtexpenditure,bankname,bankacountname,type");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
     }

    /**
     * 获得应用程序配置
     * @param id
     * @return
    */
    @GetMapping("{id}")
    public PactEnterpriseorganization find(@PathVariable("id") String id){
        return pactEnterpriseorganizationService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(PactEnterpriseorganization entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(PactEnterpriseorganization entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(PactEnterpriseorganization entity, HttpServletRequest request,
                HttpServletResponse response,BindingResult result) {
            ResponseResult responseResult = new ResponseResult();
            responseResult.ok("保存成功");
            if (hasError(entity, result)) {
                // 错误提示
                String errorMsg = errorMsg(result);
                if (!StringUtils.isEmpty(errorMsg)) {
                    responseResult.fail(ResponseError.NORMAL_ERROR,errorMsg);
                } else {
                    responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败");
                }
            }
           try {
                if (ObjectUtils.isNullOrEmpty(entity.getId())) {
                    pactEnterpriseorganizationService.insert(entity);
                } else {
                    pactEnterpriseorganizationService.insertOrUpdate(entity);
                }
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
           }
           return responseResult;
     }

    //删除
    @GetMapping("{id}/delete")
    public ResponseResult delete(@PathVariable("id") String id) {
           ResponseResult responseResult = new ResponseResult();
           responseResult.ok("删除成功");
           try {
                pactEnterpriseorganizationService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }
}
