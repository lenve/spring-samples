package org.javaboy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Service
public class UserService {

    //这个注解的含义，就表示去 Spring 容器中查找一个 UserDao 类型的 Bean，并赋值给当前变量
    @Autowired
    UserDao userDao;

    public String hello() {
        return userDao.hello();
    }

}
