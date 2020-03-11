package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.Org;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.common.common.service.ITreeCommonService;

import java.util.List;

/**
 * 机构管理服务接口
 */
public interface IOrgService extends ICommonService<Org> {
	/**
	 * 通过用户ID查找角色
	 */
	public List<Org> findListByUserId(String userid);
	/**
	 * 格式化树数据
	 * @param orgs
	 * @return
	 * @throws Exception
	 */
	List<Org> formatNodes(List<Org> orgs) throws Exception;

	/**
	 * 递归构造父级
	 * @param menu
	 * @param parents
	 * @return
	 * @throws Exception
	 */
	List<Org> makeParents(Org menu, List<Org> parents) throws Exception;
}
