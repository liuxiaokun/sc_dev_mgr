package com.lxk.mgr.config;

import com.lxk.mgr.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-21 22:07
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //权限设置
        Map<String,String> map = new HashMap<>(3);
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");
        factoryBean.setFilterChainDefinitionMap(map);
        //设置登录页面
        factoryBean.setLoginUrl("/login");
        //设置未授权页面
        factoryBean.setUnauthorizedUrl("/unauth");
        return factoryBean;
    }


    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

}