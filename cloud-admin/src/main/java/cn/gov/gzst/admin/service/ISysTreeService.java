package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.SysTree;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.common.query.data.Queryable;

import java.util.List;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-06
 */
public interface ISysTreeService extends ICommonService<SysTree> {

    /**
     * 格式化树数据
     * @param trees
     * @return
     * @throws Exception
     */
    List<SysTree> formatTreeNodes(List<SysTree> trees) throws Exception;

    /**
     * 递归构造父级
     * @param tree
     * @param parents
     * @return
     * @throws Exception
     */
    List<SysTree> makeParents(SysTree tree, List<SysTree> parents) throws Exception;

    /**
     * 生成当前节点的展示值 xx/xx/xx
     * @param tree
     * @return
     */
    String getValue(SysTree tree);

    /**
     * 根据分组编码数组获取值
     * @param groupCode
     * @param codes
     * @return
     */
    String getValues(String groupCode,String[] codes);

    /**
     * 根据父级编码获取整个树
     * @param groupCode
     * @return
     */
    List<SysTree> findTrees(String groupCode);
}
