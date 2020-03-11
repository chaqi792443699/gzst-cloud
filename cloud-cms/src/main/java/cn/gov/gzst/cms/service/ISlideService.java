package cn.gov.gzst.cms.service;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.cms.entity.Slide;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service
* @title: 幻灯片服务接口
* @description: 幻灯片服务接口
* @author: jianliaoliang
* @date: 2018-04-28 15:38:16
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
public interface ISlideService extends ICommonService<Slide> {
    Page<Slide> selectList(Page<Slide> page, @Param("ew") Wrapper<Slide> wrapper);
}