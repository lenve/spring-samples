package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo03 {
    public static void main(String[] args) {
        //这个容器，就是自动去 classpath 下面查找配置文件，并根据该配置文件启动容器
        //这行代码，会加载 Spring 的配置文件，并完成容器的初始化
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans_property_inject.xml");
        //根据名字获取一个 Bean
        User user = ctx.getBean(User.class);
        System.out.println("user = " + user);
    }
}
