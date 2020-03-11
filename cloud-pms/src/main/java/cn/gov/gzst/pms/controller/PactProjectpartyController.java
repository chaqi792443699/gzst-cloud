package cn.gov.gzst.pms.controller;


import cn.gov.gzst.pms.entity.PactProjectparty;
import cn.gov.gzst.pms.service.IPactProjectpartyService;
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
@RequestMapping("pactProjectparty")
public class PactProjectpartyController extends BaseBeanController<PactProjectparty> {
    @Autowired
    private IPactProjectpartyService pactProjectpartyService;


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
        EntityWrapper<PactProjectparty> entityWrapper = new EntityWrapper<>(PactProjectparty.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("name",keywords);


                entityWrapper.or().like("sex",keywords);


                entityWrapper.or().like("certificatename",keywords);


                entityWrapper.or().like("certificatenumber",keywords);


                entityWrapper.or().like("birthday",keywords);


                entityWrapper.or().like("telphone",keywords);


                entityWrapper.or().like("professionalpost",keywords);


                entityWrapper.or().like("workforprofession",keywords);


                entityWrapper.or().like("education",keywords);


                entityWrapper.or().like("degree",keywords);


                entityWrapper.or().like("workplace",keywords);


                entityWrapper.or().like("email",keywords);


                entityWrapper.or().like("programrole",keywords);


                entityWrapper.or().like("enterpriseid",keywords);


                entityWrapper.or().like("enterprisepartyid",keywords);


                entityWrapper.or().like("projectbaseid",keywords);


                entityWrapper.or().like("postalcode",keywords);


                entityWrapper.or().like("postaladdress",keywords);


                entityWrapper.or().like("legalcode",keywords);


                entityWrapper.or().like("workday",keywords);


                entityWrapper.or().like("userinfoid",keywords);


                entityWrapper.or().like("seq",keywords);


                entityWrapper.or().like("partynote",keywords);


                entityWrapper.or().like("joinstarttime",keywords);


                entityWrapper.or().like("joinendtime",keywords);


                entityWrapper.or().like("xmyssbid",keywords);


                entityWrapper.or().like("createtime",keywords);


                entityWrapper.or().like("createlaborfee",keywords);


                entityWrapper.or().like("totallabor",keywords);


                entityWrapper.or().like("totalpeople",keywords);


                entityWrapper.or().like("totalmoney",keywords);


                entityWrapper.or().like("ptype",keywords);


                entityWrapper.or().like("birthplace",keywords);


                entityWrapper.or().like("nation",keywords);


                entityWrapper.or().like("political",keywords);


                entityWrapper.or().like("technicaltitle",keywords);


                entityWrapper.or().like("administrativeduty",keywords);


                entityWrapper.or().like("major",keywords);


                entityWrapper.or().like("graduateschool",keywords);


                entityWrapper.or().like("graduatetime",keywords);


                entityWrapper.or().like("everaward",keywords);


                entityWrapper.or().like("jxid",keywords);


                entityWrapper.or().like("nowengaged",keywords);


                entityWrapper.or().like("contribution",keywords);


                entityWrapper.or().like("mobilephone",keywords);


                entityWrapper.or().like("signature",keywords);


                entityWrapper.or().like("xmfg",keywords);


                entityWrapper.or().like("nationname",keywords);


                entityWrapper.or().like("issys",keywords);


                entityWrapper.or().like("iswrite",keywords);


                entityWrapper.or().like("isleader",keywords);


                entityWrapper.or().like("pactid",keywords);


                entityWrapper.or().like("positiontitle",keywords);


                entityWrapper.or().like("age",keywords);


                entityWrapper.or().like("fax",keywords);


        }
        pageBean= pactProjectpartyService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,sex,certificatename,certificatenumber,birthday,telphone,professionalpost,workforprofession,education,degree,workplace,email,programrole,enterpriseid,enterprisepartyid,projectbaseid,postalcode,postaladdress,legalcode,workday,userinfoid,seq,partynote,joinstarttime,joinendtime,xmyssbid,createtime,createlaborfee,totallabor,totalpeople,totalmoney,ptype,birthplace,nation,political,technicaltitle,administrativeduty,major,graduateschool,graduatetime,everaward,jxid,nowengaged,contribution,mobilephone,signature,xmfg,nationname,issys,iswrite,isleader,pactid,positiontitle,age,fax");
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
    public PactProjectparty find(@PathVariable("id") String id){
        return pactProjectpartyService.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(PactProjectparty entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(PactProjectparty entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(PactProjectparty entity, HttpServletRequest request,
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
                    pactProjectpartyService.insert(entity);
                } else {
                    pactProjectpartyService.insertOrUpdate(entity);
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
                pactProjectpartyService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }
}
