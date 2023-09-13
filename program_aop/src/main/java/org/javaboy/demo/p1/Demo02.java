package org.javaboy.demo.p1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.target.SingletonTargetSource;

import java.lang.reflect.Method;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo02 {
    public static void main(String[] args) {
        //创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTargetSource(new TargetSource() {
            CalculatorImpl calculator = new CalculatorImpl();

            @Override
            public Class<?> getTargetClass() {
                return Calculator.class;
            }

            @Override
            public boolean isStatic() {
                return false;
            }

            @Override
            public Object getTarget() throws Exception {
                return calculator;
            }

            @Override
            public void releaseTarget(Object target) throws Exception {

            }
        });
        //设置代理对象实现的接口，这个方法可以不设置，如果调用了这个方法，即被代理的对象有接口，那么底层就使用 JDK 动态代理，否则是 CGLIB 动态代理
        proxyFactory.addInterface(Calculator.class);
        //设置通知/增强，本质上就是被代理的方法，要额外做的事情，在这个里边来完成
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                //获取被拦截的方法
                Method method = invocation.getMethod();
                String name = method.getName();
                long startTime = System.currentTimeMillis();
                //执行目标方法
                Object proceed = invocation.proceed();
                long endTime = System.currentTimeMillis();
                System.out.println(name + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
                return proceed;
            }
        });
        //获取代理对象，这里拿到的是一个 JDK 动态代理对象
        Calculator calculator = (Calculator) proxyFactory.getProxy();
        Calculator calculator2 = (Calculator) proxyFactory.getProxy();
        calculator.minus(3, 4);
    }
}
