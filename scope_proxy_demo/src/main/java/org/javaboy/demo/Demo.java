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
        UserService us1 = ctx.getBean(UserService.class);
        UserService us2 = ctx.getBean(UserService.class);
        UserDao ud1 = ctx.getBean(UserDao.class);
        UserDao ud2 = ctx.getBean(UserDao.class);
        System.out.println("us1 = " + us1);
        System.out.println("us2 = " + us2);
        System.out.println("us1.getUserDao() = " + us1.getUserDao());
        System.out.println("us2.getUserDao() = " + us2.getUserDao());
    }
}
