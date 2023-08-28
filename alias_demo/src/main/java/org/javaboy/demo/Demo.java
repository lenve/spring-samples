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
        String[] users = ctx.getAliases("user4");
        for (String user : users) {
            System.out.println("user = " + user);
        }
        Object user2 = ctx.getBean("user2");
        Object user3 = ctx.getBean("user3");
        System.out.println(user3 == user2);
    }
}
