package com.lxk.mgr;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-19 22:00
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.lxk.mgr.mapper")
public class ScDevMgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScDevMgrApplication.class, args);
    }

}
