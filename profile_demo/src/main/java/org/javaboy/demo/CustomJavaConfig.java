package org.javaboy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class CustomJavaConfig {

    @Bean
    @MyProfile("dev")
    DataSource devDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("dev");
        ds.setPassword("dev");
        ds.setUrl("jdbc:mysql:///dev");
        return ds;
    }

    @Bean
    @MyProfile("prod")
    DataSource prodDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("prod");
        ds.setPassword("prod");
        ds.setUrl("jdbc:mysql:///prod");
        return ds;
    }
}
