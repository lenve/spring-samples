package org.javaboy.demo.p2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.target.SimpleBeanTargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ProxyFactory proxyFactory = new ProxyFactory();
        //SimpleBeanTargetSource 的特点就是每次去获取代理对象的时候都要调用 getTarget 方法，而该方法都是去 Spring 容器中查找被代理的 Bean
        SimpleBeanTargetSource targetSource = new SimpleBeanTargetSource();
        //设置被代理的 Bean 的名称
        targetSource.setTargetBeanName("userService");
        //设置容器，将来就去这个容器中找被代理的 Bean
        targetSource.setBeanFactory(ctx);
        proxyFactory.setTargetSource(targetSource);
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                return invocation.proceed();
            }
        });
        UserService us1 = (UserService) proxyFactory.getProxy();
        UserService us2 = (UserService) proxyFactory.getProxy();
        UserService us3 = (UserService) proxyFactory.getProxy();
    }
}
