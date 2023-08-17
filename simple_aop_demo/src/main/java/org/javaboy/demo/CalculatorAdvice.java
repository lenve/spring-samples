package org.javaboy.demo;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class CalculatorAdvice implements MethodBeforeAdvice {
    /**
     * 目标方法被拦截下来之后，这个方法会触发，可以在这里做一些前置的事情
     *
     * @param method 拦截下来的方法
     * @param args   拦截下来的方法参数
     * @param target 拦截下来的对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName() + " 方法开始执行啦。。。");
    }
}
