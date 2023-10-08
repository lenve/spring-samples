package org.javaboy.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

/**
 * 这个 bean 一旦配置好，也是对所有的 bean 都生效的，不是只针对 Book 生效，这一点类似于 BeanFactoryPostProcessor
 * <p>
 * 所以如果只想针对某一个 Bean 生效，那么可以自行在方法中根据 beanName 进行判断
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("book".equals(beanName)) {
            Book book = (Book) bean;
            book.setId(99);
            return book;
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //如果是 book bean，就修改其属性
        if ("book".equals(beanName)) {
            Book book = (Book) bean;
            book.setName("三国演义");
            book.setPrice(20.0);
            return book;
        }
        //如果是其他类型的 bean，则直接返回对象即可
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
