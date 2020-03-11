package cn.gov.gzst.assessment.controller;


import cn.gov.gzst.assessment.entity.*;
import cn.gov.gzst.assessment.service.FinanceProcessService;
import cn.gov.gzst.assessment.service.IPgzxProcesslsatService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.assessment.service.IPgzxSfromresService;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwy
 * @since 2019-05-22
 */
@RestController
@RequestMapping("pgzxsfromres")
public class PgzxSfromresController extends BaseBeanController<PgzxSfromres> {
    @Autowired
    private IPgzxSfromresService pgzxSfromresService;
    @Autowired
    IPgzxProcesslsatService pgzxProcesslsatService;
    @Autowired
    FinanceProcessService financeProcessService;



    /**
     * 查询已提交列表
     * @param
     * @return
     */
    @ApiOperation("管理员查看待审核列表")
    @GetMapping("adminFindTodoList")
    public PageInfo adminFindTodoList(@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, HttpServletRequest request, HttpServletResponse response) {
        if(page==null){
            page=1;
        }
        if(size==null){
            size=20;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Map<String, Object>> adminFindTodoList = pgzxSfromresService.adminFindTodoList(page,size);
        for(int i=0;i<adminFindTodoList.size();i++){
            adminFindTodoList.get(i).put("APPROVAL_TIME",dateFormat.format(adminFindTodoList.get(i).get("APPROVAL_TIME")));
        }
        PageInfo todolist = new PageInfo(adminFindTodoList);
        return todolist;
    }
    /**
     * 查询已审核列表
     * @param
     * @return
     */
    @ApiOperation("管理员查看已审核列表")
    @GetMapping("adminFindDoneList")
    public PageInfo adminFindDoneList(@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "size",required = false) Integer size, HttpServletRequest request, HttpServletResponse response) {
        if(page==null){
            page=1;
        }
        if(size==null){
            size=20;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Map<String, Object>> adminFindDoneList = pgzxSfromresService.adminFindDoneList(page,size);
        for(int i=0;i<adminFindDoneList.size();i++){
            adminFindDoneList.get(i).put("APPROVAL_TIME",dateFormat.format(adminFindDoneList.get(i).get("APPROVAL_TIME")));
        }
        PageInfo donelist = new PageInfo(adminFindDoneList);
        return donelist;
    }

    /**
     * 通过合同编号模糊查询记录
     * @param pactno
     * @return
     */
    @ApiOperation("根据合同号查询列表")
    @GetMapping("findBylistPactno")
    public PageInfo findBylistPactno(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
                                     @RequestParam("pactno") String pactno, HttpServletRequest request, HttpServletResponse response) {
        List<Map<String, Object>> adminFindDoneList = pgzxSfromresService.findBylistPactno(pactno,page,size);
        PageInfo donelist = new PageInfo(adminFindDoneList);
        return donelist;
    }

    @PostMapping("adminCkeck")
    @ApiOperation("管理员审批接口")
    public ResponseResult adminCkeck(){
        ResponseResult responseResult = new ResponseResult();
        //1.前台获取数据，pactid是合同号，opinion是审核意见，state是审核状态值
        String pactid = request.getParameter("pactid");
        String opinion = request.getParameter("opinion");
        String state = request.getParameter("state");
        String userId = request.getParameter("userId");
        //根据pactid在最新纪律表里面查出该合同的id，存在时候返回具体值，可供更新用，不存在是空，savaorupdate会自动插入
       /* String pid = pgzxProcesslsatService.findIdByPactid(pactid);
        System.out.println("pid:"+pid);*/

        //2.审批纪律表拥有在执行追加操作
        FinanceProcess financeProcess = new FinanceProcess();
        financeProcess.setApprovalTime(new Date());
        financeProcess.setPactId(pactid);
        financeProcess.setApprovalId(userId);
        financeProcess.setApprovalOpinion(opinion);
        financeProcess.setApproval(state);
        financeProcessService.insert(financeProcess);

        //3.最新记录表第一次是插入，后面的都是更新操作，拥有只保存最新的一个状态值
        /*PgzxProcesslsat lastProcess = new PgzxProcesslsat();
        lastProcess.setId(pid);
        lastProcess.setApprovalTime(new Date());
        lastProcess.setPactid(pactid);
        lastProcess.setApprovalOpinion(opinion);
        lastProcess.setApproval(state);
        pgzxProcesslsatService.saveOrUpdate(lastProcess);*/


        return  responseResult.ok("操作成功！");


    }





 /*   *//**
    * 查找列表
    * @param page
     * @param limit
    * @return
    *//*
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
        EntityWrapper<PgzxSfromres> entityWrapper = new EntityWrapper<>(PgzxSfromres.class);
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)){

                entityWrapper.like("id",keywords);


                entityWrapper.or().like("pactid",keywords);


                entityWrapper.or().like("thirdclassid",keywords);


                entityWrapper.or().like("grade",keywords);


                entityWrapper.or().like("filltime",keywords);


        }
        pageBean= pgzxSfromresService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,pactid,thirdclassid,grade,filltime");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
     }

    *//**
     * 获得应用程序配置
     * @param id
     * @return
    *//*
    @GetMapping("{id}")
    @ResponseBody
    public PgzxSfromres find(@PathVariable("id") String id){
        return pgzxSfromresService.selectById(id);
    }


    //创建
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(PgzxSfromres entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    @ResponseBody
    public ResponseResult update(PgzxSfromres entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    @ResponseBody
    public ResponseResult doSave(PgzxSfromres entity, HttpServletRequest request,
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
                    pgzxSfromresService.insert(entity);
                } else {
                    pgzxSfromresService.insertOrUpdate(entity);
                }
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
           }
           return responseResult;
     }

    //删除
    @GetMapping("{id}/delete")
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
           ResponseResult responseResult = new ResponseResult();
           responseResult.ok("删除成功");
           try {
                pgzxSfromresService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }*/
}
