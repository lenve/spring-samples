package org.javaboy.demo;

import org.javaboy.demo.model.Dog;
import org.javaboy.demo.model.Person;
import org.javaboy.demo.model.User;
import org.springframework.context.support.StaticApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class ClassDerivedBeanDefinitionDemo {
    public static void main(String[] args) {
        StaticApplicationContext ctx = new StaticApplicationContext();
        //此时，会通过反射创建 Bean
        ctx.registerBean(User.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName + ">>>" + ctx.getBeanDefinition(beanDefinitionName).getClass());
        }
        //也可以传入生产者，由生产者去提供 Bean webflux
        //有生产者，bean 就是由生产者提供，否则通过反射自动创建
        ctx.registerBean(Person.class, ()->{
            Person person = new Person();
            person.setUsername("zhangsan");
            return person;
        });
        System.out.println("============");
        beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName + ">>>" + ctx.getBeanDefinition(beanDefinitionName).getClass());
        }
        Person bean = ctx.getBean(Person.class);
        System.out.println("bean = " + bean);
    }
}
