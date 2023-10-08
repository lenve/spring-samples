package org.javaboy.demo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class MethodTimeLogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String name = method.getName();
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        Object result = proxy.invokeSuper(obj, args);
        System.out.println(name + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
        return result;
    }
}
