package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        User u1 = ctx.getBean("org.javaboy.demo.User", User.class);
        User u11 = ctx.getBean("org.javaboy.demo.User#0", User.class);
        User u2 = ctx.getBean("org.javaboy.demo.User#1", User.class);
        User u3 = ctx.getBean("org.javaboy.demo.User#2", User.class);
        System.out.println("u1 = " + u1);
        System.out.println("u2 = " + u2);
        System.out.println("u3 = " + u3);
        System.out.println(u1==u11);
    }
}
