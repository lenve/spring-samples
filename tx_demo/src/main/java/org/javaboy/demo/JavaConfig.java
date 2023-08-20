package org.javaboy.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
@ComponentScan
@PropertySource("classpath:db.properties")
public class JavaConfig {
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;
    @Value("${db.url}")
    String url;

    @Bean
    TransactionTemplate transactionTemplate() {
        return new TransactionTemplate(platformTransactionManager());
    }

    /**
     * 配置事务管理器
     *
     * @return
     */
    @Bean
    PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
    }
}
