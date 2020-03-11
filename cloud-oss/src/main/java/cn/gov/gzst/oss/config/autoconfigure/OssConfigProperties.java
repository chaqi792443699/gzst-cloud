package cn.gov.gzst.oss.config.autoconfigure;

import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.oss.common.config.OssConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.config.autoconfigure
 * @title:
 * @description: shiro属性配置文件
 * @author: jianliaoliang
 * @date: 2018/3/6 10:33
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */

@ConfigurationProperties(prefix = "oss")
public class OssConfigProperties extends OssConfig {

}
