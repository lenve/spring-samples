package org.javaboy.demo.bean;

import org.javaboy.demo.model.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class UserFactoryBean implements FactoryBean<User> {

    public UserFactoryBean() {
        System.out.println("UserFactoryBean-init");
    }

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
