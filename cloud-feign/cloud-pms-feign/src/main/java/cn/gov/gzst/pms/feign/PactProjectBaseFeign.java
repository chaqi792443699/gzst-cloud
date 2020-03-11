package cn.gov.gzst.pms.feign;


import cn.gov.gzst.pms.bean.PactProjectbase;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

@FeignClient(name = "cloud-pms",fallback = PactProjectBaseFeign.class)
public interface PactProjectBaseFeign {

    @GetMapping("pactProjectbase/getPactPro")
    public Page getPactPro(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam(value = "keywords",required = false) String keywords,
                           @RequestParam(value = "annually",required = false) String annually,
                           @RequestParam(value = "applicationtypecode1",required = false) String applicationtypecode1,
                           @RequestParam(value = "projectplantypecode",required = false) String projectplantypecode,
                           @RequestParam(value = "belonglab",required = false) String belonglab,
                           @RequestParam(value = "pactStatus",required = false) String pactStatus,
                           @RequestParam(value = "minMoney",required = false) String minMoney,
                           @RequestParam(value = "maxMoney",required = false) String maxMoney);

    // 导出合同列表
    @GetMapping("pactProjectbase/exportProPact")
    public List exprotProjectPact(@RequestParam("projectIds") String projectIds);


    @GetMapping("pactProjectbase/selectProjectAndContract")
    public Map<String,Object> selectProjectAndContract(@RequestParam("projectId") String projectId);
    @GetMapping("pactProjectbase/selectProject")
    public Map<String, Object> selectProject(@RequestParam("projectId") String projectId);
    @GetMapping("pactProjectbase/selectProjcetByUser")
    public Page<Map<String, Object>> selectProjcetByUser(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam("declarantid") String declarantid);
    @GetMapping("pactProjectbase/randomProject")
    public List<Map<String, Object>> randomProject(@RequestParam(value = "keywords", required = false) String keywords,
                                                   @RequestParam(value = "applydate", required = false) String applydate,
                                                   @RequestParam(value = "applicationtypecode1", required = false) String applicationtypecode1,
                                                   @RequestParam(value = "projectplantypecode", required = false) String projectplantypecode,
                                                   @RequestParam(value = "belonglab", required = false) String belonglab,
                                                   @RequestParam(value = "pactStatus", required = false) String pactStatus,
                                                   @RequestParam(value = "minMoney",required = false) String minMoney,
                                                   @RequestParam(value = "maxMoney",required = false) String maxMoney);
    //获取基本信息
    @GetMapping("pactProjectbase/getString")
    public String getString();

    @GetMapping("pactProjectbase/adminFindListTODO")
    @ResponseBody
    public PageInfo adminFindListTODO(
            @RequestParam(name = "page",required=true,defaultValue = "1") int page,
            @RequestParam(name = "size",required=true,defaultValue = "10") int size);
    @GetMapping("pactProjectbase/selectStatus")
    public List<Map<String,Object>> selectStatus();
}
