package org.javaboy.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class MyAopBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MethodTimeLogInterceptor());
        enhancer.setSuperclass(bean.getClass());
        Object o = enhancer.create();
        return o;
    }
}
