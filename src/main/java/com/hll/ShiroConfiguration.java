package com.hll;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hll on 2016/7/18.
 */
@Configuration
public class ShiroConfiguration {

  private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

  @Bean(name = "myShiroRealm")
  public MyShiroRealm getShiroRealm() {
    return new MyShiroRealm();
  }

  @Bean(name = "shiroEhcacheManager")
  public EhCacheManager getEhCacheManager() {
    EhCacheManager em = new EhCacheManager();
    em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
    return em;
  }

  @Bean(name = "lifecycleBeanPostProcessor")
  public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
    daap.setProxyTargetClass(true);
    return daap;
  }

  @Bean(name = "securityManager")
  public DefaultWebSecurityManager getDefaultWebSecurityManager() {
    DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
    dwsm.setRealm(getShiroRealm());
    dwsm.setCacheManager(getEhCacheManager());
    return dwsm;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
    AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
    aasa.setSecurityManager(getDefaultWebSecurityManager());
    return new AuthorizationAttributeSourceAdvisor();
  }

  @Bean(name = "shiroFilter")
  public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean
        .setSecurityManager(getDefaultWebSecurityManager());
    shiroFilterFactoryBean.setLoginUrl("/login");
    shiroFilterFactoryBean.setSuccessUrl("/");
    filterChainDefinitionMap.put("/css/**", "anon");
    filterChainDefinitionMap.put("/js/**", "anon");
    filterChainDefinitionMap.put("/img/**", "anon");
    filterChainDefinitionMap.put("/fonts/**", "anon");
    filterChainDefinitionMap.put("/login", "anon");
    filterChainDefinitionMap.put("/**", "authc");

    shiroFilterFactoryBean
        .setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilterFactoryBean;
  }

}
