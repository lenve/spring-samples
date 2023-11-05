package org.javaboy.demo;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.aop.framework.autoproxy.target.AbstractBeanFactoryBasedTargetSourceCreator;
import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class UserServiceTargetSourceCreator extends AbstractBeanFactoryBasedTargetSourceCreator {

    @Override
    protected AbstractBeanFactoryBasedTargetSource createBeanFactoryBasedTargetSource(Class<?> beanClass, String beanName) {
        if (getBeanFactory() instanceof ConfigurableListableBeanFactory) {
            //如果要创建的 bean 是 UserService，返回其 UserServiceTargetSource 对象
            if (beanClass.isAssignableFrom(UserService.class)) {
                return new UserServiceTargetSource();
            }
        }
        return null;
    }
}
