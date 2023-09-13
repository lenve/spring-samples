package org.javaboy.demo;

import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new DogImpl());
        proxyFactory.addInterface(Dog.class);
        proxyFactory.addAdvisors(new IntroductionAdvisor() {
            //这个地方实际上就是窃电，ClassFilter 就是配置哪些类需要拦截
            @Override
            public ClassFilter getClassFilter() {
                //所有类都要拦截
//                return ClassFilter.TRUE;
                //我们这里只需要拦截 Dog 的方法即可
                return Dog.class::isAssignableFrom;
            }

            @Override
            public void validateInterfaces() throws IllegalArgumentException {

            }

            @Override
            public Advice getAdvice() {
                return new AnimalIntroductionInterceptor();
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }

            //生成的代理对象，额外实现的接口是什么？
            //配置之后，生成的代理对象，将来就会额外实现这个接口
            @Override
            public Class<?>[] getInterfaces() {
                return new Class[]{Animal.class};
            }
        });
        //这个时候拿到的 dog 对象实际上是一个代理对象
        Dog dog = (Dog) proxyFactory.getProxy();
        dog.run();
        System.out.println("dog.getClass() = " + dog.getClass());
        Animal animal = (Animal) dog;
        animal.eat();
        if (dog instanceof SpringProxy) {
            System.out.println("SpringProxy");
        }
    }
}
