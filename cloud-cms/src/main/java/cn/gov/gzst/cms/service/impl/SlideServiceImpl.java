package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.cms.entity.SlideData;
import cn.gov.gzst.cms.service.ISlideDataService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.ISlideService;
import cn.gov.gzst.cms.entity.Slide;
import cn.gov.gzst.cms.mapper.SlideMapper;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: 幻灯片服务实现
* @description: 幻灯片服务实现
* @author: jianliaoliang
* @date: 2018-04-28 15:38:16
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("slideService")
public class SlideServiceImpl  extends CommonServiceImpl<SlideMapper,Slide> implements  ISlideService {

    @Autowired
    private ISlideDataService slideDataService;

    @Override
    public boolean deleteById(Serializable id) {
        //删除
        slideDataService.delete(new EntityWrapper<SlideData>().eq("slideid",id));
        return super.deleteById(id);
    }

    @Override
    public Page<Slide> selectList(Page<Slide> page,@Param("ew") Wrapper<Slide> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectList(page,wrapper));
        return page;
    }
}