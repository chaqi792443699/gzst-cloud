package cn.gov.gzst.cms.controller;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.cms.entity.SlideData;
import cn.gov.gzst.cms.service.ISlideDataService;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.cms.service.ISlideService;
import cn.gov.gzst.cms.entity.Slide;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.controller
 * @title: 幻灯片控制器
 * @description: 幻灯片控制器
 * @author: jianliaoliang
 * @date: 2018-04-28 15:38:16
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("slide")
public class SlideController extends BaseBeanController<Slide> {

    @Autowired
    private ISlideService slideService;
    @Autowired
    private ISlideDataService slideDataService;


    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
    private void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Slide> entityWrapper = new EntityWrapper<Slide>(entityClass);
        //加入条件
        entityWrapper.orderBy("createDate",false);
        //加入条件
        String keyword=request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)){
            entityWrapper.like("title",keyword).or().like("tag",keyword);
        }
        pageBean= slideService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(Slide entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Slide entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Slide entity, HttpServletRequest request, HttpServletResponse response,
                                 BindingResult result) {
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
                entity.setDelFlag("1");
                slideService.insert(entity);
            } else {
                slideService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    @GetMapping("{id}/delete")
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            slideService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    /**
     * 通过tag获取
     * @param tag
     * @return
     */
    @GetMapping("{tag}/get")
    public ResponseResult get(@PathVariable("tag") String tag) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("获取成功");
        try {
            Slide slide = slideService.selectOne(new EntityWrapper<Slide>().eq("tag",tag).eq("status",'1'));
            if(slide!=null){
                responseResult.putObject(slide);
                //查询图片
                List<SlideData> slideDataList=slideDataService.selectList(new EntityWrapper<SlideData>().eq("slideid",slide.getId()).orderBy("listorder",false));
                responseResult.put("slide_data_list",slideDataList);
            }else{
                responseResult.fail(ResponseError.NORMAL_ERROR,"tag标签不可用");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    /**
     * 通过tag获取
     * @param siteId
     * @return
     */
    @PostMapping("/getslideData")
    public void getslideData(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit ,@RequestParam("siteId") String siteId,HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("获取成功");
        if(page == null){
            page = 1;
        }
        if(limit == null){
            limit = 3;
        }
        Page pageBean = new Page(page,limit);
        try {
            Slide slide = slideService.selectOne(new EntityWrapper<Slide>().eq("site_id",siteId).eq("status",'1'));
            if(slide!=null){
                responseResult.putObject(slide);
                EntityWrapper<SlideData> entityWrapper = new EntityWrapper<>(SlideData.class);
                entityWrapper.eq("slideid",slide.getId());
                entityWrapper.orderBy("create_date",false);
                //查询图片
                List<SlideData> slideDataList=slideDataService.selectList(entityWrapper);
                pageBean= slideDataService.selectPage(pageBean,entityWrapper);
                String content = JSON.toJSONString(pageBean);
                StringUtils.printJson(response, content);
                //responseResult.put("slide_data_list",slideDataList);
            }else{
                responseResult.fail(ResponseError.NORMAL_ERROR,"siteId不可用");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
    }

    /**
     * 通过站点查幻灯片
     * parem
     * **/
    @GetMapping("{siteId}/listBySiteId")
    public void selectListBySiteId(@PathVariable("siteId") String siteId,
                                   @RequestParam("page") Integer page,
                                   @RequestParam("limit") Integer limit,
                                   HttpServletResponse response,
                                   HttpServletRequest request){
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Slide> entityWrapper = new EntityWrapper<Slide>(entityClass);
        entityWrapper.eq("s.site_id",siteId);

        //加入条件
        pageBean= slideService.selectList(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }
}