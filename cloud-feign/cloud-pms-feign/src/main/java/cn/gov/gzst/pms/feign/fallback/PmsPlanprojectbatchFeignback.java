package cn.gov.gzst.pms.feign.fallback;

import cn.gov.gzst.pms.feign.PmsPlanprojectbatchFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PmsPlanprojectbatchFeignback implements PmsPlanprojectbatchFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List getAnnually() {
        logger.error("调用{}异常{}");
        return null;
    }
}
