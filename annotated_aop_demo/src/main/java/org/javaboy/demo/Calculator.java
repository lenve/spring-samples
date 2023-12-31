package org.javaboy.demo;

import org.springframework.stereotype.Component;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Component
public class Calculator {
    @TimeLog
    public int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    @TimeLog
    public void minus(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
    }
}
