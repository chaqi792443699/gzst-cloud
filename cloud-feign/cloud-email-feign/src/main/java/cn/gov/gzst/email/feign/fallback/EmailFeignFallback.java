package cn.gov.gzst.email.feign.fallback;


import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.email.feign.EmailFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.sso.server.feign.fallback
 * @title:
 * @description:
 * @author: jianliaoliang
 * @date: 2018/3/26 16:41
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@Component("emailFeign")
public class EmailFeignFallback implements EmailFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseResult send(String email, String code, Map<String, Object> datas) {
        logger.error("调用{}异常:{}", "send","email");
        return null;
    }
}
