package org.javaboy.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
@Component
@Aspect
@EnableAspectJAutoProxy
public class TimeLogAspect {

    /**
     * 切点按照注解来，即哪个方法上有 @TimeLog 注解，则哪个方法就会被拦截下来
     * 注意，@annotation(TimeLog) 只是检查方法上是否存在 TimeLog 注解
     *
     * @within(TimeLog) 表示类上有 TimeLog 注解，则类中的方法会被拦截下来
     */
    @Pointcut("@annotation(TimeLog)||@within(TimeLog)")
    public void pc1() {

    }

    @Around("pc1()")
    public Object calExecTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(pjp.getSignature().getName() + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
        return result;
    }
}
