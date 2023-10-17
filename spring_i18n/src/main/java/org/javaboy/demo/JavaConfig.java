package org.javaboy.demo;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
public class JavaConfig {

    /**
     * 这个 Bean 在注册的时候有一个要求，就是 beanName 必须是 messageSource
     * @return
     */
    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        //设置文件的基本名称
        source.setBasename("content");
        return source;
    }
}
