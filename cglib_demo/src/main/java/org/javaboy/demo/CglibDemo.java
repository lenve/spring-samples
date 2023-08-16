package org.javaboy.demo;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Calculator.class);
        enhancer.setCallback(new CalculatorProxy());
        Calculator calculator = (Calculator) enhancer.create();
        System.out.println("calculator.getClass() = " + calculator.getClass());
        calculator.minus(3, 4);
    }
}
