package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class XmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        User u1 = ctx.getBean(User.class);
        User u2 = ctx.getBean(User.class);
        System.out.println(u1 == u2);
    }
}
