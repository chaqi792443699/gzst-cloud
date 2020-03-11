package cn.gov.gzst.cms.service;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.common.common.service.ITreeCommonService;

import java.util.List;

/**
 * 内容分类管理服务
 */
public interface ICategoryService extends ITreeCommonService<Category,String> {
    /**
     * 格式化树数据
     * @param categories
     * @return
     * @throws Exception
     */
    List<Category> formatNodes(List<Category> categories) throws Exception;

    /**
     * 递归构造父级
     * @param menu
     * @param parents
     * @return
     * @throws Exception
     */
    List<Category> makeParents(Category menu, List<Category> parents) throws Exception;
}