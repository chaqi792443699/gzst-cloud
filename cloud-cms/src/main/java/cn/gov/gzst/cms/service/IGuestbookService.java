package cn.gov.gzst.cms.service;

import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.cms.entity.Guestbook;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service
* @title: cms_guestbook服务接口
* @description: cms_guestbook服务接口
* @author: 吴正军
* @date: 2018-10-29 15:58:20
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
public interface IGuestbookService extends ICommonService<Guestbook> {
    Page<Guestbook> selectList(Page<Guestbook> page, @Param("ew") Wrapper<Guestbook> wrapper);
}