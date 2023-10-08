package org.javaboy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
@ComponentScan
public class JavaConfig {

    @Bean
    MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    @Bean
    MyAopBeanPostProcessor myAopBeanPostProcessor() {
        return new MyAopBeanPostProcessor();
    }

    @Bean
    Book book() {
        return new Book();
    }
}
