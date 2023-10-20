package org.javaboy.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class BookControlFlow {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Book());
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                //如果这里只是指定了类，没有指定方法，就表示当从当前类的任意方法中去执行被代理的对象的方法的时候，方法都会被拦截
                //当然，这里也可以指定具体的方法名，如果指定了方法名就表示在指定类的指定方法中，调用被代理对象的方法，才会发生拦截
                ControlFlowPointcut pointcut = new ControlFlowPointcut(BookControlFlow.class,"m2");
                return pointcut;
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
        System.out.println("===========");
        m2(book);
    }

    public static void m2(Book book) {
        book.setName("三国演义");
        System.out.println("book.getName() = " + book.getName());
    }
}
