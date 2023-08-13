package org.javaboy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class JavaConfig {
    @Bean
    @DependsOn("b")
    A a() {
        return new A();
    }

    @Bean
    B b() {
        return new B();
    }
}


