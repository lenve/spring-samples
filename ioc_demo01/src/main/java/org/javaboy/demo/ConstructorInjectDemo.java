package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class ConstructorInjectDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans_constructor_inject.xml");
        User user = ctx.getBean(User.class);
        System.out.println("user = " + user);
        Dog dog02 = ctx.getBean("dog02", Dog.class);
        System.out.println("dog02 = " + dog02);
    }
}
