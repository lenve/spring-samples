package org.javaboy.demo;

import org.javaboy.demo.service.BookService;
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
        ICalculator calculator = ctx.getBean(ICalculator.class);
        calculator.add(3, 4);
        BookService bs = ctx.getBean(BookService.class);
        System.out.println("bs.getClass() = " + bs.getClass());
        LogAspect logAspect = ctx.getBean(LogAspect.class);
        System.out.println("logAspect.getClass() = " + logAspect.getClass());
    }
}
