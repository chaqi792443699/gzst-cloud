package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.PactProjectbase;
import cn.gov.gzst.pms.feign.PactProjectBaseFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.assessment.service.IPactProjectbaseService;
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

import cn.gov.gzst.common.common.controller.BaseBeanController;

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
@RestController
@RequestMapping("pactprojectbase")
public class PactProjectbaseController extends BaseBeanController<PactProjectbase> {
    @Autowired
    private IPactProjectbaseService pactProjectbaseService;

    @Autowired
    private PactProjectBaseFeign pactProjectBaseFeign;


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
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){
                entityWrapper.or().like("enterpriseorusersid",keywords);
                entityWrapper.or().like("planprojectbatchid",keywords);
                entityWrapper.or().like("dnjf",keywords);
        }
        pageBean= pactProjectbaseService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,enterpriseorusersid,planprojectbatchid,projectstartdate,projectenddate,projectsumforself,projectsumforgov,projecttotalsum,economicbenefit,projectcontent1,projectachievement1,projectbasename,declarant,accountfirmid,projectleader,applyspecialname,projectapplytype,projectplantype,technologicalmode,projectmanagedomain,appropriationtype,technologicalsource,maincurrentstate,maincurrentstateid,minicurrentstate,minicurrentstateid,applydate,expectedbenefitachievement,declarantid,mainorganizers,researchcontent1,projectimplementation,researchinput,mainbusinessincome,enterprisetypes,researchinstitutions,applicationno,techdomain,submitdate,iscancel,issetup,createdate,chiefdepartment,chieldofficals,casemanagement,planno,projectclassification,projectresults,projectfeatureinforid,applyspecialnamecode,projectapplytypecode,projectplantypecode,technologicalmodecode,projectmanagedomaincode,appropriationtypecode,technologicalsourcecode,currentsate,belonglab,belonglabid,industryfield,techdomaincode,industryfieldcode,subjectareas,subjectareascode,technicalrank,casemanagementcode,casemanagementid,projectclassificationcode,shgyly,shgylycode,secondprojectname,dayipingtai,zaitimingcheng,purposemean,yptqiyeleixing,researchcontent,projectcontent,projectachievement,updatelasttime,achievesalesrevenue,profits,implementpaystaxes,zttype,daxingyiqi,chuangxinquan,zaitimingchenid,showprojectbasename,batchname,possessconditions,actualpayment,truefalse,expertresult,csjyjf,cscsjg,csczjyjf,csczshjg,finalprojectname,finaltaskprojectname,xmzgid,lsxmzgid,activitiid,planprojectbatchid2,actGxc,actKjc,actSfc,actGjc,actZsc,actZlglc,actZlbhc,actCxc,actNcc,actFgc,actZsjgdw,actJjs,xmzgidGxc,xmzgidKjc,xmzgidSfc,xmzgidGjc,xmzgidZsc,xmzgidZlglc,xmzgidZlbhc,xmzgidCxc,xmzgidNcc,xmzgidFgc,xmzgidZsjgdw,xmzgidJjs,lsxmzgidGxc,lsxmzgidKjc,lsxmzgidSfc,lsxmzgidGjc,lsxmzgidZsc,lsxmzgidZlglc,lsxmzgidZlbhc,lsxmzgidCxc,lsxmzgidNcc,lsxmzgidFgc,lsxmzgidZsjgdw,lsxmzgidJjs,zhuanjiazumingdan,chushiopinion,dnjf,jzpyfl,jzpsfz,jzpshyxm,kjtopinion,defaultindex,createtime,createlaborfee,totallabor,professionaltitle,countunit,testcontentunit,testcontent,showstate,jfbzjf,htlczt,contractno,contractname,actJcc,actRsc,actJjb,xmzgidJcc,xmzgidRsc,xmzgidJjb,lsxmzgidJcc,lsxmzgidRsc,cddwmc,htxmfzr,xmhdlx,xmyzntype,xmyznly,xmyznzt,xmyzndesc,xmwcslx,xmhdlxcode,projectleaderphone,ssjsly,ssjslycode,xmwcslxcode,projectsearchtype,sfsygjmm,superuser,xmlx,keywords,enkeywords,leadercertificateno,isable,isbackstuff,izteamid,isreview,ismeeting,pactid,oldplanno,implcontent,affixes");
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
    public PactProjectbase find(@PathVariable("id") String id){
        return pactProjectbaseService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(PactProjectbase entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(PactProjectbase entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(PactProjectbase entity, HttpServletRequest request,
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
                    pactProjectbaseService.insert(entity);
                } else {
                    pactProjectbaseService.insertOrUpdate(entity);
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
                pactProjectbaseService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }


    //项目合同列表
    @GetMapping("/getPactPro")
    public void getPactPro(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit, HttpServletRequest request, HttpServletResponse response){
        if(page == null){
            page=1;
        }
        if(limit == null){
            limit =20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
        //搜索
        String keywords = request.getParameter("keywords");
        String annually = request.getParameter("annually");
        String applicationtypecode1 = request.getParameter("applicationtypecode1");
        String projectplantypecode = request.getParameter("projectplantypecode");
        String belonglab = request.getParameter("belonglab");
        String pactStatus = request.getParameter("pactStatus");
        String minMoney = request.getParameter("minMoney");
        String maxMoney = request.getParameter("maxMoney");
        //搜索
        if(!StringUtils.isEmpty(keywords)){
            entityWrapper.like("pb.pactno",keywords);
            entityWrapper.or().like("ppb.projectbasename",keywords);
        }
        if(!StringUtils.isEmpty(annually)){
            entityWrapper.eq("pppb.annually",annually);
        }
        if(!StringUtils.isEmpty(applicationtypecode1)){
            entityWrapper.eq("pppb.applicationtypecode1",applicationtypecode1);
        }
        if(!StringUtils.isEmpty(projectplantypecode)){
            entityWrapper.eq("ppb.projectplantypecode",projectplantypecode);
        }
        if(!StringUtils.isEmpty(belonglab)){
            entityWrapper.eq("ppb.belonglab",belonglab);
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
        pageBean = pactProjectbaseService.getPactPro(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,pactno,projectbasename,projectstartdate,projectenddate,jhxtzkjjf,pactStatus,batchname,belonglab,projectleaderphone,organizationname,projectleader,annually,applicationtypecode1,projectplantype,projectplantypecode,status");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
    }



    //项目合同批量导出
    @GetMapping("/exportProPact")
    public void exprotProjectPact(HttpServletResponse response,HttpServletRequest request){
        String projectIds = request.getParameter("projectIdStr");
        String projectId[] = projectIds.split(",");
        List<PactProjectbase> list = new ArrayList<>();
        for(int i=0;i<projectId.length;i++){
            EntityWrapper<PactProjectbase> entityWrapper = new EntityWrapper<>(PactProjectbase.class);
            entityWrapper.eq("ppb.id",projectId[i]);
            PactProjectbase projectbase = pactProjectbaseService.exportProPact(entityWrapper);
            list.add(projectbase);
        }
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,pactno,projectbasename,projectstartdate,projectenddate,jhxtzkjjf,pactStatus,batchname,belonglab,projectleaderphone,organizationname,projectleader,annually,applicationtypecode1,projectplantype,projectplantypecode");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(list,filter);
        StringUtils.printJson(response,content);
    }
}
