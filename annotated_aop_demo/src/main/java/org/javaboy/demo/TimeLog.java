package org.javaboy.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

/**
 * 这个注解，说白了，就是一个标记
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface TimeLog {
}
