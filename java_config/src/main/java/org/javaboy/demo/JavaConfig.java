package org.javaboy.demo;

import org.springframework.context.annotation.Bean;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 *
 * 这个就是我的配置类，这个配置类的作用类似于 beans.xml
 */
public class JavaConfig {

    /**
     * 这个就表示将当前方法的返回值注册到 Spring 容器中，默认情况下，方法名就是 beanName
     * 如果想自定义 BeanName，则可以在 @Bean 注解中进行定义。
     * @return
     */
    @Bean("u1")
    User user1(Dog dog) {
        User user = new User();
        user.setName("javaboy");
        user.setAge(99);
        user.setDog(dog);
        return user;
    }

    @Bean
    Dog dog() {
        Dog dog = new Dog();
        dog.setName("阿黄");
        dog.setAge(8);
        return dog;
    }

}
