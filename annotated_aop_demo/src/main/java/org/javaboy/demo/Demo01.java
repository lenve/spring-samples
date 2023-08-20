package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        Calculator calculator = ctx.getBean(Calculator.class);
        System.out.println("calculator.getClass() = " + calculator.getClass());
        calculator.add(2, 3);
        calculator.minus(3, 4);
    }
}
