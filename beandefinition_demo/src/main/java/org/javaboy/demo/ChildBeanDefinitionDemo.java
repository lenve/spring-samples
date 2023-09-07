package org.javaboy.demo;

import org.javaboy.demo.model.Person;
import org.javaboy.demo.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class ChildBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建一个 parent，这个中的属性将来会被 child 继承
        RootBeanDefinition parentBD = new RootBeanDefinition();
        parentBD.setBeanClass(Person.class);
        MutablePropertyValues propValues = new MutablePropertyValues();
        propValues.add("username", "javaboy");
        parentBD.setPropertyValues(propValues);
        //ChildBeanDefinition 在创建的时候必须要传入 parent
        ChildBeanDefinition childBd = new ChildBeanDefinition("parent");
        childBd.setBeanClass(User.class);
        beanFactory.registerBeanDefinition("parent", parentBD);
        beanFactory.registerBeanDefinition("user", childBd);

        User user = beanFactory.getBean("user", User.class);
        System.out.println("user = " + user);
    }
}
