package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        String msg1 = ctx.getMessage("name", null, new Locale("en", "US"));
        System.out.println("msg1 = " + msg1);
        String msg2 = ctx.getMessage("name123", null,"default_name123", new Locale("en", "US"));
        System.out.println("msg2 = " + msg2);
        Object[] arguments = new Object[]{"javaboy","Spring源码分析"};
        String msg3 = ctx.getMessage("info", arguments, new Locale("zh", "CN"));
        System.out.println("msg3 = " + msg3);
    }
}
