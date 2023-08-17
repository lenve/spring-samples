package org.javaboy.demo;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Aspect=Pointcut+Advice
 */
@Aspect
@Component
//这个相当于 <aop:aspectj-autoproxy/>，这个注解是用来识别项目中的 Aspect 的
@EnableAspectJAutoProxy
public class LogAspect {

    @Pointcut("execution(* org.javaboy.demo.CalculatorImpl.*(..))")
    public void pc1() {

    }

    /**
     * 前置通知，在被拦截下来的方法执行之前触发
     *
     * @param jp
     */
    @Before("pc1()")
    public void before(JoinPoint jp) {
        //获取被拦截下来的方法名
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法开始执行啦...");
    }

    /**
     * 后置通知，在目标方法执行之后执行
     *
     * @param jp
     */
    @After("pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法执行结束啦...");
    }

    /**
     * 异常通知，目标方法执行出错的时候触发
     * 异常通知要求方法所抛出的异常类型必须和异常通知中的参数的异常类型相匹配，才会进入到这个方法中
     *
     * @param jp
     */
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void exception(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法执行抛出 " + e.getMessage() + " 异常");
    }

    /**
     * 这个是返回通知，被拦截下来的目标方法执行完毕之后，会触发这个方法
     *
     * @param jp
     * @param result 目标方法的返回值，如果返回值为 void，则这里是 null
     *               <p>
     *               目标方法的返回值必须和这里的返回参数相匹配，该方法才会被触发
     */
    @AfterReturning(value = "pc1()",returning = "result")
    public void returnAdvice(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println(name + " 方法返回 " + result);
    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     */
    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        //这行代码表示执行目标方法
        Object proceed = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(pjp.getSignature().getName() + " 方法执行耗时 " + (endTime - startTime) + " 毫秒");
        return proceed;
    }
}
