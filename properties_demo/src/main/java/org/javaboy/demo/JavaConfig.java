package org.javaboy.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
//将配置文件注册到 Spring 容器中，作用类似于 <context:property-placeholder location="classpath:db.properties"/>
@PropertySource("classpath:db.properties")
public class JavaConfig {

    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;
    @Value("${db.url}")
    String url;

    @Bean
    DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
    }
}
