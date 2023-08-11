package org.javaboy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class JavaConfig {

    /**
     * 这两个 Bean 实际上只需要向 Spring 容器中注册一个即可
     *
     * @Conditional() 是一个条件注解，它里边需要一个条件，如果这个条件为 true，则当前 Bean 就会被注册到 Spring 容器中，否则当前 Bean 不会被注册到 Spring 容器中
     * @return
     */
    @Bean
    @Conditional(WindowsCondition.class)
    ShowCmd winCmd() {
        return new WindowsCmd();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    ShowCmd linuxCmd() {
        return new LinuxCmd();
    }
}
