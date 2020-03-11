package cn.gov.gzst.activiti.service;

import com.baomidou.mybatisplus.plugins.Page;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti.service
 * @title:
 * @description: Cache工具类
 * @author: jianliaoliang
 * @date: 2018/4/19 16:48
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public interface IProcessService {
    public Page<Object[]> processList(Page<Object[]> page, String category);

    public Page<ProcessInstance> runningList(Page<ProcessInstance> page, String procInsId, String procDefKey) ;

    public InputStream resourceRead(String procDefId, String proInsId, String resType) throws Exception;

    public String deploy(String category, MultipartFile file);

    public void updateCategory(String procDefId, String category);

    public String updateState(String state, String procDefId);

    public org.activiti.engine.repository.Model convertToModel(String procDefId) throws UnsupportedEncodingException, XMLStreamException;

    public List<String> exportDiagrams(String exportDir) throws IOException;

    public void deleteDeployment(String deploymentId);

    public void deleteProcIns(String procInsId, String deleteReason);
}
