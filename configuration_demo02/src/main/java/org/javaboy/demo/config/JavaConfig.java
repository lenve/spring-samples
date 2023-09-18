package org.javaboy.demo.config;

import org.javaboy.demo.UserService;
import org.javaboy.demo.model.Dog;
import org.javaboy.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
//@Configuration(proxyBeanMethods = false)
@ComponentScan
public class JavaConfig {
    @Bean
    User user() {
        User user = new User();
        user.setDog(dog());
        return user;
    }

    @Bean
    Dog dog() {
        return new Dog();
    }
}
