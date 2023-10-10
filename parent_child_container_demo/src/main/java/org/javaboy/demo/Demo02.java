package org.javaboy.demo;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo02 {
    public static void main(String[] args) {
        Map<String, Object> beans = new HashMap<>();
        Book book = new Book();
        book.setName("三国演义");
        beans.put("book", book);
        StaticListableBeanFactory parent = new StaticListableBeanFactory(beans);
        DefaultListableBeanFactory child = new DefaultListableBeanFactory();
        child.setParentBeanFactory(parent);
        Book b = child.getBean(Book.class);
        System.out.println("b = " + b);
    }
}
