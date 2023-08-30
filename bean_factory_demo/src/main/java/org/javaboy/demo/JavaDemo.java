package org.javaboy.demo;

import org.javaboy.demo.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class JavaDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建一个 BeanDefinition，我们通过 XML 文件或者 Java 注解配置的 Bean，最终都会被解析为一个 BeanDefinition 对象，然后再将这个 BeanDefinition 对象进行实例化
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        //设置类
        beanDefinition.setBeanClass(User.class);
        MutablePropertyValues pVs = new MutablePropertyValues();
        pVs.add("name", "JAVABOY");
        pVs.add("address", "深圳");
        //设置 bean 的属性
        beanDefinition.setPropertyValues(pVs);
        //向容器中注册一个 Bean
        beanFactory.registerBeanDefinition("user", beanDefinition);
        User user = beanFactory.getBean("user", User.class);
        System.out.println("user = " + user);
    }
}
