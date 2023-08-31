package org.javaboy.demo;

import org.javaboy.demo.bean.UserSmartFactoryBean;
import org.javaboy.demo.model.User;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        User user = ctx.getBean("user", User.class);
        UserSmartFactoryBean userSmartFactoryBean = ctx.getBean("&user", UserSmartFactoryBean.class);
//        System.out.println("user = " + user);
    }
}
