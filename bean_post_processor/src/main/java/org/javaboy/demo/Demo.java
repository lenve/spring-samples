package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        Book book = ctx.getBean(Book.class);
        System.out.println("book = " + book);
        UserService us = ctx.getBean(UserService.class);
        System.out.println("us.sayHello() = " + us.sayHello());
        System.out.println("book.getClass() = " + book.getClass());
        System.out.println("us.getClass() = " + us.getClass());
    }
}
