package org.javaboy.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import java.util.Arrays;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class BookAnnotation {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Book());
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                return new AnnotationMatchingPointcut(null, MyAction.class);
            }

            @Override
            public Advice getAdvice() {
                return new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        String name = invocation.getMethod().getName();
                        System.out.println(name+"("+ Arrays.toString(invocation.getArguments()) +")" + " 方法开始执行了...");
                        return invocation.proceed();
                    }
                };
            }
        });
        Book book = (Book) proxyFactory.getProxy();
        book.setName("三国演义");
        book.sayHello();
        book.sayHello("zhangsan");
        book.sayHello(99);
        System.out.println("book.getName() = " + book.getName());
    }
}
