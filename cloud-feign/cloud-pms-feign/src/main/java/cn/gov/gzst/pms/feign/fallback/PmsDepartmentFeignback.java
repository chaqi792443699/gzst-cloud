package cn.gov.gzst.pms.feign.fallback;

import cn.gov.gzst.pms.feign.PmsDepartmentFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PmsDepartmentFeignback implements PmsDepartmentFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List getDeptList() {
        logger.error("调用{}异常{}");
        return null;
    }
}
