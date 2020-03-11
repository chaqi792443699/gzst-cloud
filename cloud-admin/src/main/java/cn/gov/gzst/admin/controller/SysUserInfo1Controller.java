package cn.gov.gzst.admin.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.admin.entity.SysUserInfo1;
import cn.gov.gzst.admin.service.ISysUserInfo1Service;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-04
 */
@Controller
@RequestMapping("sys-user-info1")
public class SysUserInfo1Controller extends BaseBeanController<SysUserInfo1> {
    @Autowired
    private ISysUserInfo1Service sysUserInfo1Service;


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
        EntityWrapper<SysUserInfo1> entityWrapper = new EntityWrapper<>(SysUserInfo1.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("userId",keywords);


                entityWrapper.or().like("name",keywords);


                entityWrapper.or().like("contactPhone",keywords);


                entityWrapper.or().like("sex",keywords);


                entityWrapper.or().like("birthday",keywords);


                entityWrapper.or().like("qq",keywords);


                entityWrapper.or().like("email",keywords);


                entityWrapper.or().like("politicsStatus",keywords);


                entityWrapper.or().like("education",keywords);


                entityWrapper.or().like("degree",keywords);


                entityWrapper.or().like("professionalGrade",keywords);


                entityWrapper.or().like("nation",keywords);


                entityWrapper.or().like("major",keywords);


                entityWrapper.or().like("duty",keywords);


                entityWrapper.or().like("createBy",keywords);


                entityWrapper.or().like("createDate",keywords);


                entityWrapper.or().like("updateBy",keywords);


                entityWrapper.or().like("updateDate",keywords);


        }
        pageBean= sysUserInfo1Service.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,userId,name,contactPhone,sex,birthday,qq,email,politicsStatus,education,degree,professionalGrade,nation,major,duty,createBy,createDate,updateBy,updateDate");
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
    public SysUserInfo1 find(@PathVariable("id") String id){
        return sysUserInfo1Service.selectById(id);
    }


    //创建
    @PostMapping("create")
    public ResponseResult create(SysUserInfo1 entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(SysUserInfo1 entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(SysUserInfo1 entity, HttpServletRequest request,
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
                    sysUserInfo1Service.insert(entity);
                } else {
                    sysUserInfo1Service.insertOrUpdate(entity);
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
                sysUserInfo1Service.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }
}
