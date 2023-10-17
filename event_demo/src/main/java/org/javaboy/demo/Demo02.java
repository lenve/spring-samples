package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //发布事件方法
        MyEvent myEvent = new MyEvent(Demo02.class);
        myEvent.setName("张三");
        myEvent.setGender("男");
        ctx.publishEvent(myEvent);
        Book book = new Book();
        book.setName("三国演义");
        book.setPrice(22.0);
        //发布 book 类型的事件
        ctx.publishEvent(book);
        System.out.println("Demo>>>Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
}
