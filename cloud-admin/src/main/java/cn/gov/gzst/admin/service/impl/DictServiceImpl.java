package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.Dict;
import cn.gov.gzst.admin.entity.DictGroup;
import cn.gov.gzst.admin.mapper.DictMapper;
import cn.gov.gzst.admin.service.IDictGroupService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.admin.service.IDictService;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("dictService")
public class DictServiceImpl extends CommonServiceImpl<DictMapper, Dict> implements IDictService {

	@Autowired
	IDictGroupService dictGroupService;

	@Override
	public List<Dict> selectDictList() {
		return baseMapper.selectDictList();
	}

	@Override
	public String getLabel(String code, String value) {
		String content = "";
		String gid = "";
		if (!StringUtils.isEmpty(code)) {
			EntityWrapper<DictGroup> wrapper = new EntityWrapper<>(DictGroup.class);
			wrapper.eq("code",code);
			DictGroup group = this.dictGroupService.selectOne(wrapper);
			if (group != null) {
				gid = group.getId();
			}
		}
		EntityWrapper<Dict> wrapper = new EntityWrapper<>(Dict.class);
		wrapper.eq("value",value);
		if (!StringUtils.isEmpty(gid)) {
			wrapper.eq("gid",gid);
		}
		Dict dict = this.selectOne(wrapper);
		if (dict != null) {
			content = dict.getLabel();
		}
		return content;
	}

	@Override
	public String getValue(String code, String label) {
		String content = "";
		String gid = "";
		if (!StringUtils.isEmpty(code)) {
			EntityWrapper<DictGroup> wrapper = new EntityWrapper<>(DictGroup.class);
			wrapper.eq("code",code);
			DictGroup group = this.dictGroupService.selectOne(wrapper);
			if (group != null) {
				gid = group.getId();
			}
		}
		EntityWrapper<Dict> wrapper = new EntityWrapper<>(Dict.class);
		wrapper.eq("label",label);
		if (!StringUtils.isEmpty(gid)) {
			wrapper.eq("gid",gid);
		}
		Dict dict = this.selectOne(wrapper);
		if (dict != null) {
			content = dict.getValue();
		}
		return content;
	}
}
