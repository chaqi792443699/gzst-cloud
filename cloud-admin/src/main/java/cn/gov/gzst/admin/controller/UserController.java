package cn.gov.gzst.admin.controller;

import cn.gov.gzst.admin.common.bean.ResponseError;
import cn.gov.gzst.admin.entity.*;
import cn.gov.gzst.admin.feign.LogFeign;
import cn.gov.gzst.admin.service.*;
import cn.gov.gzst.common.bean.AjaxResult;
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
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseBeanController<User> {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private ISysSceneService sysSceneService;

    @Autowired
    private ISysUserInfo1Service sysUserInfo1Service;

    @Autowired
    private ISysUserInfo2Service sysUserInfo2Service;

    @Autowired
    private IPhoneVerifyCodeService phoneVerifyCodeService;

    @Autowired
    private IEmailVerifyCodeService emailVerifyCodeService;

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Permission(value = "USER_LIST")
    @ApiOperation(value = "获取用户列表，支持分页", notes = "json方法获取用户列表")
    @ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "当前页码", required = true, dataType = "int"), @ApiImplicitParam(name = "limit", value = "每页条数", required = true, dataType = "int") })
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    private void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<User> entityWrapper = new EntityWrapper<User>(entityClass);
        //文章列表
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        entityWrapper.orderBy("registerDate", false);
        //加入条件
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(keywords)) {
            entityWrapper.like("showName", keywords)
                    .or().like("username", keywords)
                    .or().like("realName", keywords)
                    .or().like("mobile", keywords)
                    .or().like("certiNum", keywords);
        }
        pageBean = userService.selectPage(pageBean, entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter("id,username,showName,realName,mobile,certiType,certiNum,avatar," +
                "type,registerIp,status,loginIp,loginDate,registerAddr");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean, filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult create(User entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult update(User entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doSave(User entity, HttpServletRequest request, HttpServletResponse response,
                                 BindingResult result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("保存成功");
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                responseResult.fail(ResponseError.NORMAL_ERROR, errorMsg);
            } else {
                responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败");
            }
        }
        try {
            if (ObjectUtils.isNullOrEmpty(entity.getId())) {
                userService.insert(entity);
            } else {
                userService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败!原因:" + e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }

    /**
     * 根据电话获取用户
     * @param phone
     * @param request
     * @param response
     */
    @RequestMapping(value = "{phone}/getUser",method = RequestMethod.GET)
    public void findUserByMobile(@PathVariable("phone") String phone,HttpServletRequest request,
                        HttpServletResponse response){
        EntityWrapper<User> entityWrapper = new EntityWrapper<>(User.class);
        entityWrapper.eq("mobile",phone);
        User user = userService.selectOne(entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter("id,username,showName,realName,mobile,certiType,certiNum,avatar," +
                "type,registerIp,status,loginIp,loginDate,registerAddr");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(user, filter);
        StringUtils.printJson(response,content);
    }


    /**
     * 通过ID获取用户信息，用于完善用户信息
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "{id}/get",method = RequestMethod.GET)
    public void findUserById(@PathVariable("id") String id,HttpServletRequest request,
                        HttpServletResponse response){
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(User.class,new String[]{"id","username","showName","realName","mobile","certiType",
                "certiNum","avatar","type","registerIp","status","loginIp","loginDate","registerAddr","userInfo"});
        EntityWrapper<User> entityWrapper = new EntityWrapper<>(User.class);
        entityWrapper.eq("id",id);
        User user = userService.selectOne(entityWrapper);
        SysUserInfo userInfo = null;
        if (user.getType() == 1) {
            EntityWrapper<SysUserInfo1> entityWrapper1 = new EntityWrapper<>(SysUserInfo1.class);
            userInfo = sysUserInfo1Service.selectOne(entityWrapper1);
        } else {
            EntityWrapper<SysUserInfo2> entityWrapper2 = new EntityWrapper<>(SysUserInfo2.class);
            userInfo = sysUserInfo2Service.selectOne(entityWrapper2);
        }
        user.setUserInfo(userInfo);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(user, filter);
        StringUtils.printJson(response,content);
    }

    /**
     * 通过ID获取用户信息，用于完善用户信息
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "{id}/data/save",method = RequestMethod.POST)
    public AjaxResult saveUserData(@PathVariable("id") String id,
                             User entity,SysUserInfo1 userInfo1,
                             SysUserInfo2 userInfo2,
                             HttpServletRequest request,
                             HttpServletResponse response){
        EntityWrapper<User> entityWrapper = new EntityWrapper<>(User.class);
        entityWrapper.eq("id",id);
        User user = userService.selectOne(entityWrapper);
        user.setRealName(entity.getRealName());
        user.setShowName(entity.getShowName());
        user.setStatus(1);
        userService.updateById(user);
        if (user.getType() == 1) {
            // 保存个人账号信息
            EntityWrapper<SysUserInfo1> entityWrapper1 = new EntityWrapper<>(SysUserInfo1.class);
            entityWrapper1.eq("userId",id);
            SysUserInfo1 userInfo11 = this.sysUserInfo1Service.selectOne(entityWrapper1);
            if (userInfo11 != null) {
                userInfo1.setId(userInfo11.getId());
                this.sysUserInfo1Service.updateById(userInfo1);
            } else {
                userInfo1.setUserId(user.getId());
                this.sysUserInfo1Service.insert(userInfo1);
            }
        } else {
            // 保存企业账号信息
            EntityWrapper<SysUserInfo2> entityWrapper1 = new EntityWrapper<>(SysUserInfo2.class);
            entityWrapper1.eq("userId",id);
            SysUserInfo2 userInfo21 = this.sysUserInfo2Service.selectOne(entityWrapper1);
            if (userInfo21 != null) {
                userInfo2.setId(userInfo21.getId());
                this.sysUserInfo2Service.updateById(userInfo2);
            } else {
                userInfo2.setUserId(user.getId());
                this.sysUserInfo2Service.insert(userInfo2);
            }
        }
        return retResult(true);
    }

    /**
     * 检查用户是否存在
     * @param entity
     * @param checkType
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "checkExist",method = RequestMethod.POST)
    @ResponseBody
    @Login(action = Action.Skip)
    public AjaxResult checkExist(User entity, String checkType, HttpServletRequest request,
                                 HttpServletResponse response){
        if (StringUtils.isEmpty(checkType)) {
            checkType = "register";
        }
        EntityWrapper<User> entityWrapper = new EntityWrapper<>(User.class);
        // 默认拼接1=1防止
        entityWrapper.eq("1","1");
        if (!StringUtils.isEmpty(entity.getMobile())) {
            entityWrapper.eq("mobile",entity.getMobile());
        }
        if (!StringUtils.isEmpty(entity.getUsername())) {
            if ("register".equals(checkType)) {
                entityWrapper.or();
            }
            entityWrapper.eq("user_name",entity.getUsername());
        }
        if (!StringUtils.isEmpty(entity.getCertiType()) && !StringUtils.isEmpty(entity.getCertiNum())) {
            entityWrapper.or().eq("certi_type",entity.getCertiType());
            entityWrapper.eq("certi_num",entity.getCertiNum());
        }
        Integer cnt = userService.selectCount(entityWrapper);
        if (cnt > 0) {
            return retResult(false);
        }
        return retResult(true);
    }

    /**
     * 获取验证码
     *
     * @param phone 手机号码
     * @param type 分类 register
     * @return
     */
    @GetMapping("{type}/phone/verifyCode")
    @Login(action = Action.Skip)
    @ResponseBody
    public ResponseResult phoneVerifyCode(@RequestParam String phone, @PathVariable String type) {
        ResponseResult responseResult=new ResponseResult();
        try {
            phoneVerifyCodeService.generateCode(phone,type);
            responseResult.ok();
        }catch (Exception e){
            responseResult.fail(ResponseError.VERIFICATIONCODE_GET_ERROR,e.getMessage());
        }
        return responseResult;
    }

    /**
     * 获取邮件验证码
     *
     * @param email 邮件
     * @param type 分类 register
     * @return
     */
    @GetMapping("{type}/email/verifyCode")
    @Login(action = Action.Skip)
    @ResponseBody
    public ResponseResult emailVerifyCode(@RequestParam String email, @PathVariable String type) {
        ResponseResult responseResult=new ResponseResult();
        try {
            emailVerifyCodeService.generateCode(email,type);
            responseResult.ok();
        }catch (Exception e){
            responseResult.fail(ResponseError.VERIFICATIONCODE_GET_ERROR);
        }
        return responseResult;
    }

    /**
     * 用户注册
     * @param entity
     * @param request
     * @param response
     * @param result
     * @return
     */
    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    @ResponseBody
    @Login(action = Action.Skip)
    public ResponseResult registerUser(User entity,String verifyCode, HttpServletRequest request, HttpServletResponse response,
                                 BindingResult result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("注册成功");
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                responseResult.fail(ResponseError.NORMAL_ERROR, errorMsg);
            } else {
                responseResult.fail(ResponseError.NORMAL_ERROR, "注册失败");
            }
        }
        try {
            //验证码校验
            Boolean flag = this.phoneVerifyCodeService.verifyCode(entity.getMobile(),"register",verifyCode);
            if (!flag) {
                responseResult.fail(ResponseError.NORMAL_ERROR, "失败!原因:验证码有误，或已过期");
                return responseResult;
            }
            //写入用户信息
            entity.setRegisterDate(new Date());
            entity.setStatus(0);
            if (entity.getType() == 2) {
                entity.setUsername(entity.getMobile());
            } else {
                entity.setShowName(entity.getUsername());
            }
            userService.insert(entity);
            //设置初始角色
            EntityWrapper<Role> entityWrapper = new EntityWrapper<Role>(Role.class);
            EntityWrapper<SysScene> entityWrapper1 = new EntityWrapper<SysScene>(SysScene.class);
            entityWrapper1.eq("code","USER_CENTER");
            SysScene sysScene = sysSceneService.selectOne(entityWrapper1);
            entityWrapper.eq("code","normal");
            //企业注册的时候，默认分配单位管理员角色，这里可考虑再角色处增加配置成默认角色的功能，以实现自动管理角色
            if (entity.getType() == 2) {
                entityWrapper.or().eq("code","unitadmin");
            }
            List<Role> roles = roleService.selectList(entityWrapper);
            EntityWrapper<User> entityWrapper2 = new EntityWrapper<User>(entityClass);
            entityWrapper2.eq("username",entity.getUsername());
            entity = userService.selectOne(entityWrapper2);
            for (Role role : roles) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(entity.getId());
                sysUserRole.setRoleId(role.getId());
                sysUserRole.setSceneId(sysScene.getId());
                sysUserRoleService.insert(sysUserRole);
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "失败!原因:" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * 找回密码
     * @param entity
     * @param verifyCode
     * @param request
     * @param response
     * @param result
     * @return
     */
    @RequestMapping(value = "findPassword", method = RequestMethod.POST)
    @ResponseBody
    @Login(action = Action.Skip)
    public ResponseResult findPassword(User entity,String verifyCode,String checkType, HttpServletRequest request, HttpServletResponse response,
                                       BindingResult result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("密码找回成功");
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                responseResult.fail(ResponseError.NORMAL_ERROR, errorMsg);
            } else {
                responseResult.fail(ResponseError.NORMAL_ERROR, "密码找回失败");
            }
        }
        try {
            //验证码校验
            if (StringUtils.isEmpty(checkType)) {
                checkType = "findPassword";
            }
            Boolean flag = this.phoneVerifyCodeService.verifyCode(entity.getMobile(),checkType,verifyCode);
            if (!flag) {
                responseResult.fail(ResponseError.NORMAL_ERROR, "失败!原因:验证码有误，或已过期");
                return responseResult;
            }
            //写入用户信息
            EntityWrapper<User> entityWrapper = new EntityWrapper<User>(entityClass);
            entityWrapper.eq("username",entity.getUsername());
            entityWrapper.eq("mobile",entity.getMobile());
            User user = userService.selectOne(entityWrapper);
            userService.changePassword(user.getId(),entity.getPassword());

        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "失败!原因:" + e.getMessage());
        }
        return responseResult;
    }
}