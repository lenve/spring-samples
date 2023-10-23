package org.javaboy.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class LogAspect {
    @Pointcut("execution(* org.javaboy.demo.service.*.*(..))")
    public void pc() {

    }

    @Before("pc()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法开始执行了...");
    }
}
