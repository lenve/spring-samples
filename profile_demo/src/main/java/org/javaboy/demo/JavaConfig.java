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
public class JavaConfig {

    /**
     * @Profile("dev") 表示当前系统环境是 dev 的时候，这个 Bean 才需要注册到 Spring 容器中
     *
     * 这里的 dev 和 prod 只是一个字符串标记，当前系统环境到底是什么，需要我们在初始化容器的时候去设置
     * @return
     */
    @Bean
    @Profile("dev")
    DataSource devDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("dev");
        ds.setPassword("dev");
        ds.setUrl("jdbc:mysql:///dev");
        return ds;
    }

    @Bean
    @Profile("prod")
    DataSource prodDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("prod");
        ds.setPassword("prod");
        ds.setUrl("jdbc:mysql:///prod");
        return ds;
    }
}
