package cn.gov.gzst.oss.mapper;

import cn.gov.gzst.oss.entity.Attachment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.oss.mapper
 * @title: 附件管理数据库控制层接口
 * @description: 附件管理数据库控制层接口
 * @author: jianliaoliang
 * @date: 2018-04-25 14:25:54
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface AttachmentMapper extends BaseMapper<Attachment> {
    
}