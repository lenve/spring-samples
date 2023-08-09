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
        //这个容器，就是自动去 classpath 下面查找配置文件，并根据该配置文件启动容器
        //这行代码，会加载 Spring 的配置文件，并完成容器的初始化
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //根据名字获取一个 Bean
        Dog dog01 = (Dog) ctx.getBean("dog");
        //根据名字获取一个 Bean，指定类型，这样拿到手的就是一个 Dog 对象了
        Dog dog02 = ctx.getBean("dog", Dog.class);
        //根据类型去获取，去 Spring 容器中查找所有 Dog 类型的 Bean
        Dog dog03 = ctx.getBean(Dog.class);
        System.out.println("dog01 = " + dog01);
        System.out.println("dog02 = " + dog02);
        System.out.println("dog03 = " + dog03);
        Dog dog3 = ctx.getBean("dog3", Dog.class);
        System.out.println("dog3 = " + dog3);
    }
}
