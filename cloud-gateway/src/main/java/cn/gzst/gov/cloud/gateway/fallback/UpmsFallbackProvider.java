package cn.gzst.gov.cloud.gateway.fallback;

import cn.gov.gzst.sso.common.bean.ResponseError;
import cn.gov.gzst.sso.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gzst.gov.cloud.gateway.fallback
 * @title:
 * @description: 路由熔断
 * @author: jianliaoliang
 * @date: 2018/4/12 16:50
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@Component
public class UpmsFallbackProvider implements FallbackProvider {

    private static final String SERVICE_DISABLE = "权限管理模块不可用";
    private static final String SERVICE_NAME="cloud-admin";
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ClientHttpResponse fallbackResponse(final Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() {
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }

            @Override
            public String getStatusText() {
                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() {
                ResponseResult responseResult = new ResponseResult();
                if (cause != null && cause.getMessage() != null) {
                    logger.error("调用:{} 异常：{}", getRoute(), cause.getMessage());
                    responseResult.fail(ResponseError.NORMAL_ERROR, cause.getMessage());
                    return new ByteArrayInputStream(JSON.toJSONString(responseResult).getBytes());
                } else {
                    logger.error("调用:{} 异常：{}", getRoute(), SERVICE_DISABLE);
                    responseResult.fail(ResponseError.NORMAL_ERROR,SERVICE_DISABLE);
                    return new ByteArrayInputStream(JSON.toJSONString(responseResult).getBytes());
                }
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }

    @Override
    public String getRoute() {
        return SERVICE_NAME;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return fallbackResponse(null);
    }
}
