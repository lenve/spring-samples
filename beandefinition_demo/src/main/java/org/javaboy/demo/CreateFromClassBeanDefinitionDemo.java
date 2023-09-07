package org.javaboy.demo;

import org.javaboy.demo.config.JavaConfig;
import org.javaboy.demo.model.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class CreateFromClassBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ConfigurableListableBeanFactory beanFactory = ctx.getBeanFactory();
        //这个方法只是会创建 User 实例，并不会将创建出来的 User 实例注册到 Spring 容器中，但是，这个方法会让创建出来的 User 实例走一遍当前容器中的 BeanPostProcessor
        User user = beanFactory.createBean(User.class);
        System.out.println("user = " + user);
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            System.out.println(beanDefinitionName+">>>"+beanDefinition.getClass());
        }
        User bean = beanFactory.getBean(User.class);
        System.out.println("bean = " + bean);
    }
}
