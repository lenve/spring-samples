package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        //当我们去调用容器的 start 方法的时候，就会触发 lifecycle#start 方法
//        ctx.start();
        //当我们去调用容器的 stop/close 方法的时候，就会触发 lifecycle#stop 方法
        ctx.stop();
//        ctx.close();
    }
}
