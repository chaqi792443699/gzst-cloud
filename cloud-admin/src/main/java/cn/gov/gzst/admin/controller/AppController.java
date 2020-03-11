package cn.gov.gzst.admin.controller;

import cn.gov.gzst.admin.entity.App;
import cn.gov.gzst.admin.service.IAppService;
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
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * 应用管理
 */
@Controller
@RequestMapping("app")
public class AppController  extends BaseBeanController<App> {
    @Autowired
    private IAppService appService;


    /**
     * 查找应用程序列表
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
        EntityWrapper<App> entityWrapper = new EntityWrapper<>(App.class);
        String title = request.getParameter("keyword");
        if (!StringUtils.isEmpty(title)){
            entityWrapper.like("title",title);
        }
        pageBean= appService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,title,appKey,appToken,appSecret,icon,path,url,remarks");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
    }

    //修改
    @PostMapping("{id}/update")
    public ResponseResult update(App entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(App entity, HttpServletRequest request, HttpServletResponse response,
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
                entity.setAppKey(UUID.randomUUID().toString());
                entity.setAppToken(UUID.randomUUID().toString());
                entity.setAppSecret(UUID.randomUUID().toString());
                appService.insert(entity);
            } else {
                entity.setAppKey(UUID.randomUUID().toString());
                entity.setAppToken(UUID.randomUUID().toString());
                entity.setAppSecret(UUID.randomUUID().toString());
                appService.insertOrUpdate(entity);
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
            appService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }


    /**
     * 获得应用程序配置
     * @param appKey
     * @return
     */
    @GetMapping("{appKey}")
    public App findByAppKey(@PathVariable("appKey") String appKey){
        EntityWrapper<App> ew = new EntityWrapper(App.class);
        ew.eq("app_key",appKey);
        return appService.selectOne(ew);
    }

    /**
     * 查询clientId 是否有效
     * @param clientId
     * @return
     */
    @GetMapping("checkClientId/{clientId}")
    public Boolean checkClientId(@PathVariable String clientId) {
        return  appService.selectOne(new EntityWrapper<App>().eq("app_key",clientId)) != null;
    }

    /**
     * 查询密钥是否有效
     * @param clientSecret
     * @return
     */
    @GetMapping("checkClientSecret/{clientSecret}")
    public Boolean checkClientSecret(@PathVariable String clientSecret) {
        return appService.selectOne(new EntityWrapper<App>().eq("app_secret",clientSecret)) != null;
    }

    @GetMapping("list/avalable")
    @Login(action = Action.Skip)
    @ResponseBody
    public List<App> listAvalable() {
        EntityWrapper<App> entityWrapper = new EntityWrapper<>(App.class);
        entityWrapper.eq("available",1);
        List<App> apps = appService.selectList(entityWrapper);
        return apps;
    }

}
