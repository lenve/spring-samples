package org.javaboy.demo;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

/**
 * 现在我们是要将 UserServiceCreator 设置给 AnnotationAwareAspectJAutoProxyCreator 这个 Bean，设置的思路就是通过 BeanPostProcessor 去设置
 * 即，当 AnnotationAwareAspectJAutoProxyCreator  bean 创建完成之后，通过我们自定义的 Bean 后置处理器 SetUserServiceCreator 为这个 AnnotationAwareAspectJAutoProxyCreator 设置属性
 */
@Component
public class SetUserServiceCreator implements BeanFactoryAware, BeanPostProcessor, PriorityOrdered {
    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 这个是指当前 BeanPostProcessor 执行的优先级。
     * 首先我们要明确一点，SetUserServiceCreator 作为 BeanPostProcessor 的优先级一定要高于 AnnotationAwareAspectJAutoProxyCreator，
     * 原因很简单，AnnotationAwareAspectJAutoProxyCreator 将来在创建的时候，创建完成之后，要给 AnnotationAwareAspectJAutoProxyCreator 通过 SetUserServiceCreator 去设置属性
     * 所以，SetUserServiceCreator 优先级一定要高于 AnnotationAwareAspectJAutoProxyCreator，否则 AnnotationAwareAspectJAutoProxyCreator 创建的时候，还不存在
     * SetUserServiceCreator，那也就无法为 AnnotationAwareAspectJAutoProxyCreator 设置属性了。
     *
     * AnnotationAwareAspectJAutoProxyCreator 实现了 Ordered 接口，并且优先级最高。因此，在 Ordered 这种优先级体系下，没法定义一个优先级高于 AnnotationAwareAspectJAutoProxyCreator 的 BeanPostProcessor
     * 所以，我们这里的 SetUserServiceCreator 实现了 PriorityOrdered 接口，通过这个接口来定义优先级。
     * 因为在优先级体系中，PriorityOrdered 优先于 Ordered。
     * 所以，这个 getOrder 方法返回什么无所谓，关键是实现 PriorityOrdered 接口
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 如果当前 bean 是 AnnotationAwareAspectJAutoProxyCreator 类型的，则为之添加 setCustomTargetSourceCreators 属性
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AnnotationAwareAspectJAutoProxyCreator creator) {
            UserServiceTargetSourceCreator userServiceTargetSourceCreator = new UserServiceTargetSourceCreator();
            userServiceTargetSourceCreator.setBeanFactory(beanFactory);
            creator.setCustomTargetSourceCreators(userServiceTargetSourceCreator);
            return creator;
        }
        return bean;
    }
}
