package org.javaboy.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class DemoInterceptorAll {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new CalculatorImpl());
        proxyFactory.addInterface(ICalculator.class);
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                //这里直接返回 Pointcut 对象，这个对象中分两部分：
                //ClassFilter 和 MethodMatcher
                //再针对这两部分单独处理
                return Pointcut.TRUE;
            }

            @Override
            public Advice getAdvice() {
                return new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        long startTime = System.currentTimeMillis();
                        Object proceed = invocation.proceed();
                        long endTime = System.currentTimeMillis();
                        System.out.println(invocation.getMethod().getName() + "(" + Arrays.toString(invocation.getArguments()) + ")" + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
                        return proceed;
                    }
                };
            }
        });
        ICalculator calculator = (ICalculator) proxyFactory.getProxy();
        calculator.add(3, 4);
        calculator.add(1, 2, 3);
        calculator.minus(5, 6);
    }
}
