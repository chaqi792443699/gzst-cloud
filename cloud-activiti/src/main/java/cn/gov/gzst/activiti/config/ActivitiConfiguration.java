package cn.gov.gzst.activiti.config;

import cn.gov.gzst.activiti.modeler.explorer.JsonpCallbackFilter;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.activiti.spring.boot.ActivitiProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.UUID;

/**
 * 配置分布式主键策略
 */
@Configuration
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({ActivitiProperties.class})
public class ActivitiConfiguration extends AbstractProcessEngineAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(StrongUuidGenerator springProcessUuidGenerator,DataSource dataSource, PlatformTransactionManager transactionManager, SpringAsyncExecutor springAsyncExecutor) throws IOException {
        SpringProcessEngineConfiguration config = this.baseSpringProcessEngineConfiguration(dataSource, transactionManager, springAsyncExecutor);
        //解决中文乱码问题
        config.setActivityFontName("宋体");
        config.setLabelFontName("宋体");
        config.setIdGenerator(springProcessUuidGenerator);
        config.setDbIdentityUsed(Boolean.FALSE);
        return config;
    }

    @Bean
    public StrongUuidGenerator springProcessUuidGenerator(){
        StrongUuidGenerator uuidGenerator=new StrongUuidGenerator();
        return uuidGenerator;
    }

    @Bean
    public JsonpCallbackFilter filter(){
        return new JsonpCallbackFilter();
    }

    public static class StrongUuidGenerator implements IdGenerator {
        public String getNextId() {
            return UUID.randomUUID().toString().replace("-","");
        }
    }
}