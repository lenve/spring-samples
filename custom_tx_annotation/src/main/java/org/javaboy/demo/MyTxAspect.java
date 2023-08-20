package org.javaboy.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
public class MyTxAspect {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Pointcut("@annotation(MyTx)||@within(MyTx)")
    public void pc1() {

    }

    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        Object result = null;
        try {
            result = pjp.proceed();
            transactionManager.commit(status);
        } catch (Throwable e) {
//            throw new RuntimeException(e);
            transactionManager.rollback(status);
        }
        return result;
    }

}
