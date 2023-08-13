package org.javaboy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Controller
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 这个是构造器注入，当 Spring 容器初始化 UserController 的时候，会调用这个构造方法，结果这个构造方法需要 UserService 参数，
     * 此时 Spring 容器就会去查找在容器中是否存在 UserService 实例，如果存在，则直接使用之。
     * @param userService
     */
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    public UserController() {
//    }



    public String hello() {
        return userService.hello();
    }
}
