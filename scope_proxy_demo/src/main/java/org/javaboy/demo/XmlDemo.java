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
        UserService us1 = ctx.getBean(UserService.class);
        UserService us2 = ctx.getBean(UserService.class);
        System.out.println("us1 = " + us1);
        System.out.println("us2 = " + us2);
        System.out.println("us1.getUserDao() = " + us1.getUserDao());
        System.out.println("us2.getUserDao() = " + us2.getUserDao());
    }
}
