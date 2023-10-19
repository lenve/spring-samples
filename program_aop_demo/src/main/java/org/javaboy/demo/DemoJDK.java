package org.javaboy.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class DemoJDK {
    public static void main(String[] args) {
        //无论是 JDK 动态代理还是 CGLIB 动态代理，在 Spring 框架中都进行了封装，统一使用 ProxyFactory 来调用
        //ProxyFactory 对象会根据我们传入的参数以及被代理对象的实际情况，来自动决定是使用 JDK 动态代理还是 CGLIB 动态代理
        ProxyFactory proxyFactory = new ProxyFactory();
        //这个是我们的代理对象，目标对象
        proxyFactory.setTarget(new CalculatorImpl());
        //设置被代理对象的接口，被代理对象有接口，那么默认情况下，就可以使用 JDK 动态代理
        proxyFactory.addInterface(ICalculator.class);
//        proxyFactory.setOptimize(true);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                long startTime = System.currentTimeMillis();
                //执行目标方法
                Object proceed = invocation.proceed();
                long endTime = System.currentTimeMillis();
                System.out.println(invocation.getMethod().getName() + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
                return proceed;
            }
        });
        ICalculator calculator = (ICalculator) proxyFactory.getProxy();
        System.out.println("calculator.getClass() = " + calculator.getClass());
        calculator.add(3, 4);
        calculator.minus(2, 3);
    }
}
