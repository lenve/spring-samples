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
public class DemoAdvisor {
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
                return new Pointcut() {
                    //这里是返回要拦截的类
                    @Override
                    public ClassFilter getClassFilter() {
                        return new ClassFilter() {
                            @Override
                            public boolean matches(Class<?> clazz) {
                                //如果正在执行的类是 CalculatorImpl，则拦截
                                return CalculatorImpl.class.isAssignableFrom(clazz);
                            }
                        };
                    }

                    //这里是返回要拦截的方法
                    @Override
                    public MethodMatcher getMethodMatcher() {
                        return new MethodMatcher() {
                            /**
                             * 这个地方单纯只是根据方法名进行判断，如果有重载的方法，那么重载的方法就都被拦截了
                             * @param method the candidate method
                             * @param targetClass the target class
                             * @return
                             */
                            @Override
                            public boolean matches(Method method, Class<?> targetClass) {
                                return method.getName().equals("add");
                            }

                            /**
                             * 这个方法如果返回 true，就表示运行时再去进行方法的匹配，此时，下面这个三个参数的 matches 就会被调用
                             * 如果这个方法返回 false，那么上面两个参数的 matches 方法会被调用
                             * @return
                             */
                            @Override
                            public boolean isRuntime() {
                                return true;
                            }

                            /**
                             * 这里就不仅根据方法名进行判断，还根据方法参数进行判断
                             * @param method the candidate method
                             * @param targetClass the target class
                             * @param args arguments to the method
                             * @return
                             */
                            @Override
                            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                                return method.getName().equals("add") && args.length == 3;
                            }
                        };
                    }
                };
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
