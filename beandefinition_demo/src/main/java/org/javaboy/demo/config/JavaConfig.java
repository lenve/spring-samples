package org.javaboy.demo.config;

import org.javaboy.demo.model.Dog;
import org.javaboy.demo.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
//@ComponentScan(basePackages = "org.javaboy.demo.service")
public class JavaConfig {

    @Bean
    BeanPostProcessor beanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println(bean.getClass()+"==========postProcessBeforeInitialization==========="+beanName);
                return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
            }
        };
    }

//    @Bean
//    User user() {
//        User user = new User();
//        user.setDog(dog());
//        return user;
//    }
//
//    @Bean
//    Dog dog() {
//        return new Dog();
//    }
}
