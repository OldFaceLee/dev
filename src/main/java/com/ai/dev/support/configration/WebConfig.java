package com.ai.dev.support.configration;

import com.ai.dev.support.sysdate.ISysDateObtain;
import com.ai.dev.support.sysdate.database.MySQLDBSysDateObtain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/27 上午11:56
 * @description: spring-boot-web配置
 */
@EnableWebMvc
@Configuration
public class WebConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public ISysDateObtain sysDateProducer(){
        return new MySQLDBSysDateObtain(dataSource);
    }
}
