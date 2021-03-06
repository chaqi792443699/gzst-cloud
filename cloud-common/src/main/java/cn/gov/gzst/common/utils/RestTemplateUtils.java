package cn.gov.gzst.common.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @title: RestTemplateUtils.java
 * @package cn.dataact.common.util
 * @description: 请求工具
 * @author: jianliaoliang
 * @date: 2017年5月22日 下午9:25:14
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public class RestTemplateUtils {

    private static RestTemplate restTemplate = new RestTemplate();

    public static String post(ServletRequest req, String url, Map<String, ?> params) {
        ResponseEntity<String> rss = request(req, url, HttpMethod.POST, params);
        return rss.getBody();
    }

    public static String get(ServletRequest req, String url, Map<String, ?> params) {
        ResponseEntity<String> rss = request(req, url, HttpMethod.GET, params);
        return rss.getBody();
    }

    public static String delete(ServletRequest req, String url, Map<String, ?> params) {
        ResponseEntity<String> rss = request(req, url, HttpMethod.DELETE, params);
        return rss.getBody();
    }

    public static String put(ServletRequest req, String url, Map<String, ?> params) {
        ResponseEntity<String> rss = request(req, url, HttpMethod.PUT, params);
        return rss.getBody();
    }

    /**
     * @param req
     * @param url
     * @param method
     * @param params maybe null
     * @return
     */
    private static ResponseEntity<String> request(ServletRequest req, String url, HttpMethod method, Map<String, ?> params) {
        HttpServletRequest request = (HttpServletRequest) req;
        //获取header信息
        HttpHeaders requestHeaders = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            requestHeaders.add(key, value);
        }
        HttpEntity<String> requestEntity = new HttpEntity<String>(params != null ? JSONObject.toJSONString(params) : null, requestHeaders);
        ResponseEntity<String> rss = restTemplate.exchange(url, method, requestEntity, String.class);
        return rss;
    }
}