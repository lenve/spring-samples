package org.javaboy.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
@ComponentScan(basePackages = "org.javaboy.demo",useDefaultFilters = false,includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller))
public class JavaConfig {
}
