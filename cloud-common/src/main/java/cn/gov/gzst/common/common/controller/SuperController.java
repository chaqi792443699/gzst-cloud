package cn.gov.gzst.common.common.controller;

import cn.gov.gzst.common.bean.AjaxResult;
import cn.gov.gzst.common.exception.WebException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.common.util.HttpUtil;
import com.baomidou.kisso.security.token.SSOToken;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuperController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    public SuperController() {
    }

    protected String getCurrentUserId() {
        return this.getSSOToken().getId();
    }

    protected SSOToken getSSOToken() {
        SSOToken tk = (SSOToken)SSOHelper.attrToken(this.request);
        if (tk == null) {
            throw new WebException("-1", "The user does not exist, please relogin.");
        } else {
            return tk;
        }
    }

    protected <T> Page<T> getPage() {
        return this.getPage(20);
    }

    protected <T> Page<T> getPage(int size) {
        int _size = size;
        int _index = 1;
        if (this.request.getParameter("_size") != null) {
            _size = Integer.parseInt(this.request.getParameter("_size"));
        }

        if (this.request.getParameter("_index") != null) {
            _index = Integer.parseInt(this.request.getParameter("_index"));
        }

        return new Page(_index, _size);
    }

    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    protected boolean isPost() {
        return HttpUtil.isPost(this.request);
    }

    protected String toJson(Object object) {
        return JSON.toJSONString(object, new SerializerFeature[]{SerializerFeature.BrowserCompatible});
    }

    protected String toJson(Object object, String format) {
        return JSON.toJSONStringWithDateFormat(object, format, new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat});
    }

    protected String callback(AjaxResult object) {
        return this.callback(object, (String)null);
    }

    protected String callback(AjaxResult object, String format) {
        String callback = this.request.getParameter("callback");
        if (callback == null) {
            return this.toJson(object, format);
        } else {
            StringBuffer json = new StringBuffer();
            json.append(callback);
            json.append("(").append(this.toJson(object, format)).append(")");
            return json.toString();
        }
    }

    protected String callbackSuccess(Object obj) {
        return this.callback(new AjaxResult().success(obj));
    }

    protected String callbackFail(String message) {
        return this.callback(new AjaxResult().failure(message));
    }
}
