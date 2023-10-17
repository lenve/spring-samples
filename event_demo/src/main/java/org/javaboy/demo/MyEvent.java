package org.javaboy.demo;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件对象，定义之后，可以继承自 ApplicationEvent
 *
 * 事件对象可以是一个继承自 ApplicationEvent 的类，也可以是一个普通类
 */
public class MyEvent extends ApplicationEvent {
    private String name;
    private String gender;

    @Override
    public String toString() {
        return "MyEvent{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                "} " + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 这个参数是事件的源，即这个事件是由谁来发起的
     * @param source
     */
    public MyEvent(Object source) {
        super(source);
    }

}
