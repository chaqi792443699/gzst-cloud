package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.Log;
import cn.gov.gzst.admin.mapper.LogMapper;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.admin.service.ILogService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("logService")
public class LogServiceImpl extends CommonServiceImpl<LogMapper, Log> implements ILogService {
	@Override
	public Page<Log> selectPage(Page<Log> page, Wrapper<Log> wrapper) {
		wrapper.eq("1", "1");
		page.setRecords(baseMapper.selectLogPage(page, wrapper));
		return page;
	}
}
