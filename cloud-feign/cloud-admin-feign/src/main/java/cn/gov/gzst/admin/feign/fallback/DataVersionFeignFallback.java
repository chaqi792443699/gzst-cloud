package cn.gov.gzst.admin.feign.fallback;

import cn.gov.gzst.admin.bean.DataVersion;
import cn.gov.gzst.admin.bean.User;
import cn.gov.gzst.admin.feign.DataVersionFeign;
import cn.gov.gzst.admin.feign.UserFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
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
public class DataVersionFeignFallback implements DataVersionFeign{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public DataVersion addVersion(String jsonData, String businessKey, String businessType) {
        return null;
    }

    @Override
    public DataVersion getNewestDataVersion(String businessKey, String businessType) {
        return null;
    }

    @Override
    public DataVersion getDataVersion(String businessKey, String businessType, String version) {
        return null;
    }
}
