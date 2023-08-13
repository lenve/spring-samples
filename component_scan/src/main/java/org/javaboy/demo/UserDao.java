package org.javaboy.demo;

import org.springframework.stereotype.Repository;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 *
 *
 * Spring 中，默认提供了
 * @Repository：这个注解一般是加载 Dao 层上的
 * @Service：这个注解一般是加在 Service 层上的
 * @Controller：这个注解一般是加载 Controller 层上的
 * @Component：对于一些身份不明的 Bean，则可以使用这个注解
 *
 * 本质上来说，这四个注解其实作用没有大的差别，基本上是一样的，其他注解基本上都是衍生自 @Component
 *
 */
@Repository("ud")
public class UserDao {

    public String hello() {
        return "hello component scan";
    }
}
