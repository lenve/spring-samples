package org.javaboy.demo;

import org.javaboy.demo.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class RootBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //这是一个普通的 BeanDefinition
        RootBeanDefinition bd = new RootBeanDefinition();
        //设置 class
        bd.setBeanClass(User.class);
//        bd.setScope("singleton");
        MutablePropertyValues propValues = new MutablePropertyValues();
        propValues.add("username", "javaboy");
        //设置 User 类中各个属性的值
        bd.setPropertyValues(propValues);
        //DefaultListableBeanFactory 容器中声明了一个变量 beanDefinitionMap，key 就是 beanName，value 就是具体的 BeanDefinition
        beanFactory.registerBeanDefinition("user", bd);
        User user1 = beanFactory.getBean("user", User.class);
        User user2 = beanFactory.getBean("user", User.class);
        System.out.println(user2==user1);
        System.out.println("user1 = " + user1);
    }
}
