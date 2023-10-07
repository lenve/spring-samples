package org.javaboy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
//容器中得有一个名为 a 的 bean，B 才能注册到 Spring 容器中去
@Conditional(MyCondition.class)
public class B {

}
