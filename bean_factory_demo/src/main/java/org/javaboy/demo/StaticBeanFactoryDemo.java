package org.javaboy.demo;

import org.javaboy.demo.model.User;
import org.springframework.beans.factory.support.StaticListableBeanFactory;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class StaticBeanFactoryDemo {
    public static void main(String[] args) {
        StaticListableBeanFactory beanFactory = new StaticListableBeanFactory();
        User user1 = new User();
        user1.setName("江南一点雨");
        user1.setAddress("广州");
        beanFactory.addBean("user1", user1);
        User bean = beanFactory.getBean(User.class);
        System.out.println("bean = " + bean);
    }
}
