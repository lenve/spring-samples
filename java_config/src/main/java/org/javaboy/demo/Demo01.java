package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo01 {
    public static void main(String[] args) {
        //加载 Java 代码配置的容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user = ctx.getBean("u1", User.class);
        System.out.println("user = " + user);
        Dog dog = ctx.getBean("dog", Dog.class);
        System.out.println("(user.getDog()==dog) = " + (user.getDog() == dog));
    }
}
