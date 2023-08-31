package org.javaboy.demo.bean;

import org.javaboy.demo.model.User;
import org.springframework.beans.factory.SmartFactoryBean;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class UserSmartFactoryBean implements SmartFactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    /**
     * 这个方法返回 true，表示是单例，返回 false，表示是非单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * 是否是多例的，默认是 false
     *
     * @return
     */
    @Override
    public boolean isPrototype() {
        return false;
    }

    /**
     * 是否提前初始化，FactoryBean 中，默认情况下，它提供的 Bean 是懒加载的，即用户调用 getBean 方法的时候，才会初始化这个 bean
     * 如果想要提前初始化 getObject 方法中返回的 Bean，那么可以在这里返回 true
     */
    @Override
    public boolean isEagerInit() {
        return true;
    }
}
