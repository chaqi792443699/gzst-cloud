package cn.gov.gzst.pms.controller;


import cn.gov.gzst.pms.entity.PactProjectexpense;
import cn.gov.gzst.pms.service.IPactProjectexpenseService;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@Controller
@RequestMapping("pactProjectexpense")
public class PactProjectexpenseController extends BaseBeanController<PactProjectexpense> {
    @Autowired
    private IPactProjectexpenseService pactProjectexpenseService;


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
        EntityWrapper<PactProjectexpense> entityWrapper = new EntityWrapper<>(PactProjectexpense.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("selfsum",keywords);


                entityWrapper.or().like("applyprovicegvosum",keywords);


                entityWrapper.or().like("totalsum",keywords);


                entityWrapper.or().like("instrumentsum",keywords);


                entityWrapper.or().like("businesstripsum",keywords);


                entityWrapper.or().like("adviceforexpertsum",keywords);


                entityWrapper.or().like("materialexpense",keywords);


                entityWrapper.or().like("servicefee",keywords);


                entityWrapper.or().like("adminstrativeservicesum",keywords);


                entityWrapper.or().like("proceedingscharges",keywords);


                entityWrapper.or().like("coferemce",keywords);


                entityWrapper.or().like("coorperationresearchsum",keywords);


                entityWrapper.or().like("fuelandpower",keywords);


                entityWrapper.or().like("managesum",keywords);


                entityWrapper.or().like("applycitysum",keywords);


                entityWrapper.or().like("getcitysum",keywords);


                entityWrapper.or().like("realamount",keywords);


                entityWrapper.or().like("projectbaseid",keywords);


                entityWrapper.or().like("getapplyprovicegvosumdate",keywords);


                entityWrapper.or().like("getapplyprovicegvosum",keywords);


                entityWrapper.or().like("getselfsum",keywords);


                entityWrapper.or().like("getselfsumdate",keywords);


                entityWrapper.or().like("qita",keywords);


                entityWrapper.or().like("incentivefee",keywords);


                entityWrapper.or().like("foreigninvestment",keywords);


                entityWrapper.or().like("unitmoney",keywords);


                entityWrapper.or().like("departmentsmatching",keywords);


                entityWrapper.or().like("othermoney",keywords);


                entityWrapper.or().like("enterpriseresearchspending",keywords);


                entityWrapper.or().like("equipmentone",keywords);


                entityWrapper.or().like("materialone",keywords);


                entityWrapper.or().like("processingtestone",keywords);


                entityWrapper.or().like("expenditureone",keywords);


                entityWrapper.or().like("inlandtravelone",keywords);


                entityWrapper.or().like("conferenceone",keywords);


                entityWrapper.or().like("publishedone",keywords);


                entityWrapper.or().like("incentiveone",keywords);


                entityWrapper.or().like("managementone",keywords);


                entityWrapper.or().like("collaborativeresearchone",keywords);


                entityWrapper.or().like("domesticresearchersone",keywords);


                entityWrapper.or().like("overseasexpertsone",keywords);


                entityWrapper.or().like("laborone",keywords);


                entityWrapper.or().like("domesticlaborone",keywords);


                entityWrapper.or().like("overseaslaborone",keywords);


                entityWrapper.or().like("consultingone",keywords);


                entityWrapper.or().like("domesticconsultingone",keywords);


                entityWrapper.or().like("overseasconsultingone",keywords);


                entityWrapper.or().like("equipmenttwo",keywords);


                entityWrapper.or().like("equipmentthree",keywords);


                entityWrapper.or().like("equipmentfour",keywords);


                entityWrapper.or().like("instrumentsum3",keywords);


                entityWrapper.or().like("instrumentsum2",keywords);


                entityWrapper.or().like("instrumentsum1",keywords);


                entityWrapper.or().like("xmsbsid",keywords);


                entityWrapper.or().like("instrumentsum1note",keywords);


                entityWrapper.or().like("instrumentsum2note",keywords);


                entityWrapper.or().like("instrumentsum3note",keywords);


                entityWrapper.or().like("materialexpensenote",keywords);


                entityWrapper.or().like("proceedingschargesnote",keywords);


                entityWrapper.or().like("fuelandpowernote",keywords);


                entityWrapper.or().like("businesstripsumnote",keywords);


                entityWrapper.or().like("conferemcenote",keywords);


                entityWrapper.or().like("coorperationresearchsumnote",keywords);


                entityWrapper.or().like("adminstrativeservicesumnote",keywords);


                entityWrapper.or().like("servicefeenote",keywords);


                entityWrapper.or().like("adviceforexpertsumnote",keywords);


                entityWrapper.or().like("instrumentsumkjt",keywords);


                entityWrapper.or().like("instrumentsum1kjt",keywords);


                entityWrapper.or().like("instrumentsum2kjt",keywords);


                entityWrapper.or().like("instrumentsum3kjt",keywords);


                entityWrapper.or().like("materialexpensekjt",keywords);


                entityWrapper.or().like("proceedingschargeskjt",keywords);


                entityWrapper.or().like("fuelandpowerkjt",keywords);


                entityWrapper.or().like("businesstripsumkjt",keywords);


                entityWrapper.or().like("coferemcekjt",keywords);


                entityWrapper.or().like("coorperationresearchsumkjt",keywords);


                entityWrapper.or().like("adminstrativeservicesumkjt",keywords);


                entityWrapper.or().like("servicefeekjt",keywords);


                entityWrapper.or().like("adviceforexpertsumkjt",keywords);


                entityWrapper.or().like("managesumkjt",keywords);


                entityWrapper.or().like("qitakjt",keywords);


                entityWrapper.or().like("totalsumkjt",keywords);


                entityWrapper.or().like("jhtzze",keywords);


                entityWrapper.or().like("ywctz",keywords);


                entityWrapper.or().like("ywctzzc",keywords);


                entityWrapper.or().like("jhxztz",keywords);


                entityWrapper.or().like("jhxtzkjjf",keywords);


                entityWrapper.or().like("jhxtzzc",keywords);


                entityWrapper.or().like("jhxtzqtbk",keywords);


                entityWrapper.or().like("totalzjsum",keywords);


                entityWrapper.or().like("totalzjsumkjt",keywords);


                entityWrapper.or().like("totaljjsum",keywords);


                entityWrapper.or().like("totaljjsumkjt",keywords);


                entityWrapper.or().like("jxzc",keywords);


                entityWrapper.or().like("jxzckjt",keywords);


                entityWrapper.or().like("clhygjhz",keywords);


                entityWrapper.or().like("clhygjhzkjt",keywords);


                entityWrapper.or().like("pactid",keywords);


                entityWrapper.or().like("gjqtbk",keywords);


                entityWrapper.or().like("bmbk",keywords);


                entityWrapper.or().like("dfbk",keywords);


                entityWrapper.or().like("qily",keywords);


                entityWrapper.or().like("totalsumzc",keywords);


                entityWrapper.or().like("instrumentsumzc",keywords);


                entityWrapper.or().like("instrumentsum1zc",keywords);


                entityWrapper.or().like("instrumentsum2zc",keywords);


                entityWrapper.or().like("instrumentsum3zc",keywords);


                entityWrapper.or().like("adviceforexpertsumzc",keywords);


                entityWrapper.or().like("materialexpensezc",keywords);


                entityWrapper.or().like("servicefeezc",keywords);


                entityWrapper.or().like("adminstrativeservicesumzc",keywords);


                entityWrapper.or().like("proceedingschargeszc",keywords);


                entityWrapper.or().like("fuelandpowerzc",keywords);


                entityWrapper.or().like("totalzjsumzc",keywords);


                entityWrapper.or().like("totaljjsumzc",keywords);


                entityWrapper.or().like("jxzczc",keywords);


                entityWrapper.or().like("clhygjhzzc",keywords);


                entityWrapper.or().like("qitazc",keywords);


                entityWrapper.or().like("xsjlfy",keywords);


                entityWrapper.or().like("syyqclzlfxfy",keywords);


                entityWrapper.or().like("tdrypxfy",keywords);


                entityWrapper.or().like("yslxfy",keywords);


                entityWrapper.or().like("lwzjzxfy",keywords);


                entityWrapper.or().like("bfppjf",keywords);


                entityWrapper.or().like("kjtbk1",keywords);


                entityWrapper.or().like("kjtbk2",keywords);


                entityWrapper.or().like("xpgwjf",keywords);


                entityWrapper.or().like("kjtbk3",keywords);


                entityWrapper.or().like("kzkxyj",keywords);


        }
        pageBean= pactProjectexpenseService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,selfsum,applyprovicegvosum,totalsum,instrumentsum,businesstripsum,adviceforexpertsum,materialexpense,servicefee,adminstrativeservicesum,proceedingscharges,coferemce,coorperationresearchsum,fuelandpower,managesum,applycitysum,getcitysum,realamount,projectbaseid,getapplyprovicegvosumdate,getapplyprovicegvosum,getselfsum,getselfsumdate,qita,incentivefee,foreigninvestment,unitmoney,departmentsmatching,othermoney,enterpriseresearchspending,equipmentone,materialone,processingtestone,expenditureone,inlandtravelone,conferenceone,publishedone,incentiveone,managementone,collaborativeresearchone,domesticresearchersone,overseasexpertsone,laborone,domesticlaborone,overseaslaborone,consultingone,domesticconsultingone,overseasconsultingone,equipmenttwo,equipmentthree,equipmentfour,instrumentsum3,instrumentsum2,instrumentsum1,xmsbsid,instrumentsum1note,instrumentsum2note,instrumentsum3note,materialexpensenote,proceedingschargesnote,fuelandpowernote,businesstripsumnote,conferemcenote,coorperationresearchsumnote,adminstrativeservicesumnote,servicefeenote,adviceforexpertsumnote,instrumentsumkjt,instrumentsum1kjt,instrumentsum2kjt,instrumentsum3kjt,materialexpensekjt,proceedingschargeskjt,fuelandpowerkjt,businesstripsumkjt,coferemcekjt,coorperationresearchsumkjt,adminstrativeservicesumkjt,servicefeekjt,adviceforexpertsumkjt,managesumkjt,qitakjt,totalsumkjt,jhtzze,ywctz,ywctzzc,jhxztz,jhxtzkjjf,jhxtzzc,jhxtzqtbk,totalzjsum,totalzjsumkjt,totaljjsum,totaljjsumkjt,jxzc,jxzckjt,clhygjhz,clhygjhzkjt,pactid,gjqtbk,bmbk,dfbk,qily,totalsumzc,instrumentsumzc,instrumentsum1zc,instrumentsum2zc,instrumentsum3zc,adviceforexpertsumzc,materialexpensezc,servicefeezc,adminstrativeservicesumzc,proceedingschargeszc,fuelandpowerzc,totalzjsumzc,totaljjsumzc,jxzczc,clhygjhzzc,qitazc,xsjlfy,syyqclzlfxfy,tdrypxfy,yslxfy,lwzjzxfy,bfppjf,kjtbk1,kjtbk2,xpgwjf,kjtbk3,kzkxyj");
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
    public PactProjectexpense find(@PathVariable("id") String id){
        return pactProjectexpenseService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(PactProjectexpense entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(PactProjectexpense entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(PactProjectexpense entity, HttpServletRequest request,
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
                    pactProjectexpenseService.insert(entity);
                } else {
                    pactProjectexpenseService.insertOrUpdate(entity);
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
                pactProjectexpenseService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }
}
