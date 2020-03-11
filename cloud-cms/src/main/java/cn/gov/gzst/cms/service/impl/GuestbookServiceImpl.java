package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.IGuestbookService;
import cn.gov.gzst.cms.entity.Guestbook;
import cn.gov.gzst.cms.mapper.GuestbookMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: cms_guestbook服务实现
* @description: cms_guestbook服务实现
* @author: 吴正军
* @date: 2018-10-29 15:58:20
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("guestbookService")
public class GuestbookServiceImpl  extends CommonServiceImpl<GuestbookMapper,Guestbook> implements  IGuestbookService {

    @Override
    public Page<Guestbook> selectList(Page<Guestbook> page,@Param("ew") Wrapper<Guestbook> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectList(page, wrapper));
        return page;
    }
}