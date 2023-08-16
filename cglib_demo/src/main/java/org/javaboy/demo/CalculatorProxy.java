package org.javaboy.demo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve public class CalculatorProxy extends Calculator{
 * int add(int a,int b){
 * //xxxx
 * super.add(a,b);
 * //xxx
 * }
 * }
 */
public class CalculatorProxy implements MethodInterceptor {
    /**
     * 这个就是拦截器，将来 org.javaboy.demo.Calculator#minus(int, int) 方法执行的时候，这个拦截器会被触发，额外的工作就可以在这个方法中完成
     *
     * @param o           代理对象
     * @param method      代理方法
     * @param objects     方法的参数
     * @param methodProxy 方法的代理对象
     * @return 拦截下来的方法的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long startTime = System.currentTimeMillis();
        //相当于调用父类的方法，因为 CGLIB 动态代理，相当于给当前类生成了一个子类，在子类中添加了额外的逻辑
        Object result = methodProxy.invokeSuper(o, objects);
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
        return result;
    }
}
