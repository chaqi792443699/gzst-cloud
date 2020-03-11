package cn.gov.gzst.activiti.service;

import com.baomidou.mybatisplus.plugins.Page;
import org.activiti.engine.repository.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti.service
 * @title:
 * @description: 流程模型相关
 * @author: jianliaoliang
 * @date: 2018/4/19 12:35
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public interface IModelService {

    public Page<Model> modelList(Page<org.activiti.engine.repository.Model> page, String category);

    public Model create(String name, String key, String description, String category) throws UnsupportedEncodingException;

    public String deploy(String id);

    public void export(String id, HttpServletResponse response);

    public void updateCategory(String id, String category);

    public void delete(String id);
}
