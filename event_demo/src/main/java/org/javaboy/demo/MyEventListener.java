package org.javaboy.demo;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 事件的消费者/事件的监听器
 * 这块也有两种定义方式
 * 第一种就是实现 ApplicationListener 接口，在接口的泛型中指定要处理的事件类型
 */
//@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    private MyEventListener02 myEventListener02;

    public MyEventListener02 getMyEventListener02() {
        return myEventListener02;
    }

    public void setMyEventListener02(MyEventListener02 myEventListener02) {
        this.myEventListener02 = myEventListener02;
    }

    /**
     * 由于前面指定了这里是处理 MyEvent 事件的，因此，如果发送的是 Book 事件，是不会进入到这个方法中进行处理的
     * @param event
     */
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyEventListener : " + event);
        System.out.println("MyEventListener>>>Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
}
