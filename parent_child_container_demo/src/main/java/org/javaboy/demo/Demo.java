package org.javaboy.demo;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
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
        ClassPathXmlApplicationContext parent = new ClassPathXmlApplicationContext();
        parent.setConfigLocations("parent.xml");
        parent.refresh();
        ClassPathXmlApplicationContext child = new ClassPathXmlApplicationContext();
        child.setConfigLocations("child.xml");
        child.setParent(parent);
        child.refresh();
        Book book = child.getBean("book", Book.class);
//        Book book = child.getBean(Book.class);
        System.out.println("book = " + book);
    }
}
