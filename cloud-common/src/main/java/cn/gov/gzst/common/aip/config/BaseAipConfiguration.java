package cn.gov.gzst.common.aip.config;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.utils
 * @title:
 * @description: 百度客户端构建
 * @author: jianliaoliang
 * @date: 2018/4/21 17:50
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */

import cn.gov.gzst.common.aip.recognizer.BusinessLicenseRecognizer;
import cn.gov.gzst.common.aip.recognizer.IdcardRecognizer;
import com.baidu.aip.ocr.AipOcr;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  客户端配置
 */
@Configuration
@EnableConfigurationProperties({BaseAipProperties.class})
public class BaseAipConfiguration {

    @Bean
    public AipOcr aipOcr(BaseAipProperties baseAipProperties){
       AipOcr aipOcr = new AipOcr(baseAipProperties.getAppId(), baseAipProperties.getApiKey(), baseAipProperties.getSecretKey());
       return aipOcr;
    }

    @Bean
    public IdcardRecognizer idcardRecognizer(AipOcr aipOcr){
        IdcardRecognizer idcardRecognizer = new IdcardRecognizer(aipOcr);
        return idcardRecognizer;
    }

    @Bean
    public BusinessLicenseRecognizer businessLicenseRecognizer(AipOcr aipOcr){
        BusinessLicenseRecognizer businessLicenseRecognizer = new BusinessLicenseRecognizer(aipOcr);
        return businessLicenseRecognizer;
    }
}
