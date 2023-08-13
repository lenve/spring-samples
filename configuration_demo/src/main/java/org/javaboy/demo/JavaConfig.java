package org.javaboy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Configuration
public class JavaConfig {

    @Bean
    Dog dog() {
        Dog dog = new Dog();
        dog.setName("小黄");
        dog.setAge(9);
        return dog;
    }

    @Bean
    User user() {
        User user = new User();
        user.setName("javaboy");
        user.setDog(dog());
        return user;
    }
}
