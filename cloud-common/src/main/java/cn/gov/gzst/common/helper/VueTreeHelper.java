package cn.gov.gzst.common.helper;


import cn.gov.gzst.common.common.entity.tree.TreeNode;
import cn.gov.gzst.common.filter.xss.JsonUnXssFilter;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.utils.BeanUtils;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.Reflections;
import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 树排序
 *
 * @author jianliaoliang
 *
 */
public class VueTreeHelper<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2444638065060902858L;

    private List<TreeNode<ID>> treeNodes;

    public static <T extends Serializable> VueTreeHelper<T> create() {
        VueTreeHelper<T> treeSortUtil = new VueTreeHelper<T>();
        return treeSortUtil;
    }

    /**
     * 获得根节点
     */
    private List<VueTreeNode> getTopNodes(String fields) {
        List<VueTreeNode> list = new ArrayList<VueTreeNode>();
        for (TreeNode<ID> treeable : treeNodes) {
            if (treeable.isRoot()) {
                list.add(new VueTreeNode(treeable,fields));
            }
        }
        return list;
    }

    /**
     * 解析根节点
     *
     * @param node
     */
    private void parseSubNode(VueTreeNode node,String fields) {
        List<VueTreeNode> newTreeNodes = new ArrayList<VueTreeNode>();
        for (TreeNode<ID> treeable : treeNodes) {
            if (!ObjectUtils.isNullOrEmpty(treeable.getParentId()) && treeable.getParentId().equals(node.getNodeId())) {
                VueTreeNode vueTreeNode = new VueTreeNode(treeable,fields);
                newTreeNodes.add(vueTreeNode);
                parseSubNode(vueTreeNode,fields);
                node.setChildren(newTreeNodes);
            }
        }
    }

    /**
     * 运行排序
     */
    public List<VueTreeNode> sort(List<?> treeNodes) {
        return this.sort(treeNodes,"");
    }

    public List<VueTreeNode> sort(List<?> treeNodes, String fields) {
        this.treeNodes = (List<TreeNode<ID>>) treeNodes;
        List<VueTreeNode> rootNodes = getTopNodes(fields);
        for (VueTreeNode rootNode : rootNodes) {
            parseSubNode(rootNode,fields);
        }
        this.treeNodes.clear();
        return rootNodes;
    }

    /**
     * 这里可以优化一下，可以配置子节点的key,以及可以修改
     */
    public static class VueTreeNode extends HashMap<String, Object> {
        private final static String PAREND_ID_KEY="VueTreeNode_parendId";

        public Object getNodeId() {
            return this.get(PAREND_ID_KEY);
        }

        public VueTreeNode(TreeNode<?> treeNode) {
            putObject(treeNode,"");
        }


        public VueTreeNode(TreeNode<?> treeNode, String fieldName) {
            //配置ID,用于匹配
            this.put(PAREND_ID_KEY,treeNode.getId());
            putObject(treeNode,fieldName);
        }

        public VueTreeNode putObject(Object object, String fieldName) {
            PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter(fieldName);
            SerializeFilter propertyPreFilter = propertyPreFilterable.constructFilter(object.getClass());
            JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
            SerializeFilter[] filters={propertyPreFilter,jsonUnFilter};
            String objectStr= JSON.toJSONString(object,filters);
            Map dataMap= JSON.parseObject(objectStr,Map.class);
            putAll(dataMap);
            return this;
        }

        public void setChildren(List<VueTreeNode> children) {
            this.put("children",children);
        }
    }
}


