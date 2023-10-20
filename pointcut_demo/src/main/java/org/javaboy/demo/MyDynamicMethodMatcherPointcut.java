package org.javaboy.demo;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class MyDynamicMethodMatcherPointcut extends DynamicMethodMatcherPointcut {
    /**
     * 两个参数的 matches 方法已经重写了，这里就不需要重写了
     *
     * @param method      the candidate method
     * @param targetClass the target class
     * @param args        arguments to the method
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return method.getName().equals("sayHello") && args.length == 1 && String.class.isAssignableFrom(args[0].getClass());
    }
}
