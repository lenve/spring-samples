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
        //注意配置类的顺序，将来 Spring 容器加载的时候就是按照这两个配置类的顺序来加载的
        // 先 A 后 B 没问题
        // 先 B 后 A，由于 B 在加载的时候，容器中并不存在一个名为 A 的 bean，所以 B 的条件注解就不满足，所以 B 就没有注册进来
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(B.class, A.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
