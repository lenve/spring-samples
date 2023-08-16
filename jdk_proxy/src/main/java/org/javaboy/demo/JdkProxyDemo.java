package org.javaboy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 *
 *
 * 下面生成的 calculator 是一个代理对象，注意，这个 calculator 对象并不是 CalculatorImpl 的对象
 *
 * 相当于，在代码运行的过程中，自动生成了一个代理类：
 *
 * public CalculatorProxy implements ICalculator{
 *     int add(int a,int b){
 *         long startTime = System.currentTimeMillis();
 *         //这个地方调用了 CalculatorImpl 类的实例的 add 方法，去执行了真正的 add 操作
 *         long endTime = System.currentTimeMillis();
 *         System.out.println(method.getName() + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
 *         return invoke;
 *     }
 * }
 *
 * 最后，我们调用 calculator.add 方法的时候，其实执行的是这个代理的对象的 add 方法
 *
 */
public class JdkProxyDemo {
    public static void main(String[] args) {
        CalculatorImpl calculatorImpl = new CalculatorImpl();
        //第二个参数表示生成的代理对象要实现哪些接口
        ICalculator calculator = (ICalculator) Proxy.newProxyInstance(JdkProxyDemo.class.getClassLoader(), new Class[]{ICalculator.class}, new InvocationHandler() {
            /**
             * @param proxy 当前代理对象
             * @param method 被拦截下来的方法
             * @param args 被拦截下来的方法参数
             *
             * @return 被拦截下来的方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long startTime = System.currentTimeMillis();
                Object invoke = method.invoke(calculatorImpl, args);
                long endTime = System.currentTimeMillis();
                System.out.println(method.getName() + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
                return invoke;
            }
        });
        System.out.println("calculator.getClass() = " + calculator.getClass());
        calculator.add(3, 4);
    }
}
