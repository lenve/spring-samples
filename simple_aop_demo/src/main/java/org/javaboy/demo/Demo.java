package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //这里我们去获取一个计算器的实现类
        //需要注意，这里返回的是一个代理对象，是自动生成的，并非我们当时注册到 Spring 容器中的 CalculatorImpl 对象
        ICalculator calculator = ctx.getBean("calculator",ICalculator.class);
        calculator.add(3, 4);
        calculator.minus(3, 4);
    }
}
