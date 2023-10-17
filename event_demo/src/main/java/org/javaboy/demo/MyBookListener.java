package org.javaboy.demo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Component
public class MyBookListener {

    //注解中的泛型，就表示这个方法要处理的事件的类型，这里指定为 Book，即这个方法只处理 Book 类型的事件，对于其他类型的事件如 MyEvent 是不会处理的
    @EventListener(Book.class)
    public void handleBook(Book book) {
        System.out.println("MyBookListener : " + book);
        System.out.println("MyBookListener>>>Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }

}
