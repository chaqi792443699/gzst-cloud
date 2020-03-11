package cn.gov.gzst.pms.feign.fallback;

import cn.gov.gzst.pms.bean.PactProjectbase;
import cn.gov.gzst.pms.feign.PactProjectBaseFeign;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public class PactProjectBaseFeignback implements PactProjectBaseFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page getPactPro(Integer page, Integer limit, String keywords, String annually, String applicationtypecode1,
                           String projectplantypecode, String belonglab, String pactStatus, String minMoney,String maxMoney) {
        logger.error("调用{}异常{}","page","limit");
        return null;
    }

    @Override
    public List exprotProjectPact(String projectIds) {
        logger.error("调用异常");
        return null;
    }


    @Override
    public Map<String,Object> selectProjectAndContract(String projectId) {
        logger.error("调用异常");
        return null;
    }

    @Override
    public Map<String, Object> selectProject(String projectId) {
        logger.error("调用异常");
        return null;
    }

    @Override
    public Page<Map<String, Object>> selectProjcetByUser(Integer page,Integer limit,String declarantid) {
        logger.error("调用异常");
        return null;
    }

    @Override
    public List<Map<String, Object>> randomProject(String keywords, String applydate, String applicationtypecode1, String projectplantypecode, String belonglab, String pactStatus,String minMoney,String maxMoney) {
        logger.error("调用异常");
        return null;
    }


    @Override
    public String getString() {
        return null;
    }

    @Override
    public PageInfo adminFindListTODO(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "10") int size) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectStatus() {
        return null;
    }
}
