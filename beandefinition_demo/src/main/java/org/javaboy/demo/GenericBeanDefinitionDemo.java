package org.javaboy.demo;

import org.javaboy.demo.model.Person;
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
public class GenericBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        GenericBeanDefinition parentBD = new GenericBeanDefinition();
        parentBD.setBeanClass(Person.class);
        MutablePropertyValues propValues = new MutablePropertyValues();
        propValues.add("username", "江南一点雨");
        parentBD.setPropertyValues(propValues);
        GenericBeanDefinition childBD = new GenericBeanDefinition();
        childBD.setBeanClass(User.class);
        childBD.setParentName("parent");
        beanFactory.registerBeanDefinition("parent", parentBD);
        beanFactory.registerBeanDefinition("user", childBD);
        User user = beanFactory.getBean("user", User.class);
        System.out.println("user = " + user);
    }
}
