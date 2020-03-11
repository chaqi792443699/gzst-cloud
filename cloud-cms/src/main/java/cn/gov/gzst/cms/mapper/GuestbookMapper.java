package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Guestbook;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.mapper
 * @title: cms_guestbook数据库控制层接口
 * @description: cms_guestbook数据库控制层接口
 * @author: 吴正军
 * @date: 2018-10-29 15:58:20
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface GuestbookMapper extends BaseMapper<Guestbook> {

 List<Guestbook> selectList(Page<Guestbook> page,@Param("ew") Wrapper<Guestbook> wrapper);
}