package org.javaboy.demo;

import org.javaboy.demo.config.JavaConfig;
import org.javaboy.demo.model.Dog;
import org.javaboy.demo.model.User;
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
        User user = ctx.getBean(User.class);
        JavaConfig javaConfig = ctx.getBean(JavaConfig.class);
        Dog dog = user.getDog();
        System.out.println("dog = " + dog);
        Dog dog1 = ctx.getBean(Dog.class);
        System.out.println("dog1 = " + dog1);
    }
}
