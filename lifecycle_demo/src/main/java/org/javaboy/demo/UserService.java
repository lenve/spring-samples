package org.javaboy.demo;

import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Service
public class UserService implements Lifecycle {
    private boolean isRunning = false;

    /**
     * 当容器启动的时候，可以触发这个方法
     */
    @Override
    public void start() {
        isRunning = true;
        System.out.println("UserService-start");
    }

    /**
     * 当容器销毁的时候，触发这个方法
     */
    @Override
    public void stop() {
        isRunning = false;
        System.out.println("UserService-stop");
    }

    /**
     * 判断容器是否在运行，容器中所有组件都在运行时，这里可以返回 true
     *
     * @return
     */
    @Override
    public boolean isRunning() {
        System.out.println("UserService-isRunning");
        return isRunning;
    }
}
