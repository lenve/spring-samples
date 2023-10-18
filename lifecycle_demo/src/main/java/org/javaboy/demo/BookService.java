package org.javaboy.demo;/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class BookService implements SmartLifecycle {
    private boolean isRunning = false;
    @Override
    public void start() {
        isRunning = true;
        System.out.println("start");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("isRunning");
        return isRunning;
    }

    /**
     * 是否自动触发，这个默认返回 true
     *
     * @return
     */
    @Override
    public boolean isAutoStartup() {
        System.out.println("isAutoStartup");
        return true;
    }

    /**
     * 容器销毁的时候会触发这个方法，但是注意，此时容器就不会主动去调用无参的 stop 方法了，我们需要在当前这个带参数的 stop 方法中，手动去调用无参的 stop 方法（如果需要的话）
     * @param callback
     */
    @Override
    public void stop(Runnable callback) {
        System.out.println("stop(callback)");
        stop();
        new Thread(callback).start();
    }

    /**
     * 如果同时存在多个 SmartLifecycle，那么通过该字段的返回值来决定执行顺序
     * 返回值越小，优先级越高；返回值越大，优先级越低
     * 默认返回的优先级是最低的
     * @return
     */
    @Override
    public int getPhase() {
        System.out.println("getPhase");
        return SmartLifecycle.super.getPhase();
    }
}
