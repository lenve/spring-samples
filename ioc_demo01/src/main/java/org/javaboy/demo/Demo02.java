package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo02 {
    public static void main(String[] args) {
        //这个容器，就是自动去 classpath 下面查找配置文件，并根据该配置文件启动容器
        //这行代码，会加载 Spring 的配置文件，并完成容器的初始化
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //根据名字获取一个 Bean
        Dog dog01 = (Dog) ctx.getBean("org.javaboy.demo.Dog");
        Dog dog02 = (Dog) ctx.getBean("org.javaboy.demo.Dog#1");
        Dog dog03 = (Dog) ctx.getBean("org.javaboy.demo.Dog#2");
        System.out.println("dog01 = " + dog01);
        System.out.println("dog02 = " + dog02);
        System.out.println("dog03 = " + dog03);
    }
}
