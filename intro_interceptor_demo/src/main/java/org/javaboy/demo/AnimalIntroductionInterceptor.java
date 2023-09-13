package org.javaboy.demo;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

/**
 * 这个东西本质上就是 Spring AOP 中的通知/增强
 * 但是需要注意，这里他也是 Animal 的一个实例
 */
public class AnimalIntroductionInterceptor implements IntroductionInterceptor, Animal {
    /**
     * 这个就是目标方法被拦截下来的时候，这个方法会被触发
     * 我将来是要给 Dog 生成代理对象，那么当我调用 Dog 对象中的方法的时候，这个 invoke 就会被触发
     * 但是！！！
     * 将来我拿到 dog 对象之后，我不仅可以调用 dog 中自有的方法，也可以调用 animal 中的方法
     * @param invocation the method invocation joinpoint
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
            //如果是 Animal，则应该直接调用这里的 eat 方法
            //这个就会触发当前对象中 eat 方法的调用
            return invocation.getMethod().invoke(this, invocation.getArguments());
        }
        //这个是调用 dog 中的方法
        return invocation.proceed();
    }

    /**
     * 判断传入的 class 是否为当前对象
     *
     * @param intf the interface to check
     * @return
     */
    @Override
    public boolean implementsInterface(Class<?> intf) {
        return intf.isAssignableFrom(this.getClass());
    }

    @Override
    public void eat() {
        System.out.println("animal is eat");
    }
}
