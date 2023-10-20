package org.javaboy.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class BookRegexpDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Book());
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                JdkRegexpMethodPointcut regexp = new JdkRegexpMethodPointcut();
                //注意这里要写方法的完整路径
                regexp.setPatterns("org.javaboy.demo.Book.set.*");
                regexp.setExcludedPatterns("org.javaboy.demo.Book.setName");
                return regexp;
            }

            @Override
            public Advice getAdvice() {
                return new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        String name = invocation.getMethod().getName();
                        System.out.println(name + " 方法开始执行了...");
                        return invocation.proceed();
                    }
                };
            }
        });
        Book book = (Book) proxyFactory.getProxy();
        book.setName("三国演义");
        System.out.println("book.getName() = " + book.getName());
    }
}
