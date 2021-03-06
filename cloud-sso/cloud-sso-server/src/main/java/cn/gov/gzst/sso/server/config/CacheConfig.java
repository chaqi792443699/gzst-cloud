package cn.gov.gzst.sso.server.config;

import org.apache.log4j.Logger;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 数据库缓存配置
 */

@Configuration
//@EnableCaching//标注启动缓存.
public class CacheConfig {
    public final Logger log = Logger.getLogger(this.getClass());
    /**
     *  ehcache 主要的管理器
     * @param ehCacheManagerFactoryBean
     * @return
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean ehCacheManagerFactoryBean){
        log.info("CacheConfiguration.ehCacheCacheManager()");
        return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
    }

    /*
       * 据shared与否的设置,
       * Spring分别通过CacheManager.create()
       * 或new CacheManager()方式来创建一个ehcache基地.
       *
       * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
       *
       */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        log.info("CacheConfiguration.ehCacheManagerFactoryBean()");
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
        cacheManagerFactoryBean.setConfigLocation (new ClassPathResource("ehcache/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }

}
