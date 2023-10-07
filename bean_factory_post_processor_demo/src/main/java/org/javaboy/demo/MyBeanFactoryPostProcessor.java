package org.javaboy.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */

/**
 * 这个后置处理器定义好之后，会对所有的 Bean 生效
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * 这个接口就是用来处理 beanDefinition 的，此时各个对象的 beanDefinition 都已经收集好，但是还没有创建 Bean 对象
     * 相当于我们在正式创建 Bean 对象之前，先把 BeanDefintion 中的属性值给篡改了，这样，将来创建出来的 Bean 对象的值就是修改后的属性了
     *
     * @param beanFactory the bean factory used by the application context
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
        //获取所有的 beanDefinition
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //根据 beanDefinitionName 去获取具体的 BeanDefinition 对象
            BeanDefinition bd = beanFactory.getBeanDefinition(beanDefinitionName);
            //创建一个 BeanDefinitionVisitor 对象，这个对象可以用来访问并修改 BeanDefinition 中的属性值
            //假设我一会给一个 bean 设置属性值为 ^username，如果我发现 bean 的属性名是 ^username，我就将之改为 javaboy666
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(strVal -> {
                if ("^username".equals(strVal)) {
                    return "javaboy666";
                }
                //对于其他的属性值，原封不动返回即可
                return strVal;
            });
            //更新 BeanDefinition 对象，其实就是将 visitor 中的属性值，重新赋值到原本的 BeanDefinition 上去
            visitor.visitBeanDefinition(bd);
        }
    }
}
