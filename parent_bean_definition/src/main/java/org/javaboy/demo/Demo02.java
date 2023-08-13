package org.javaboy.demo;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //我们关于 Bean 的配置，都会被先解析为 BeanDefinition
        RootBeanDefinition pbd = new RootBeanDefinition();
        pbd.setBeanClass(Animal.class);
        MutablePropertyValues pValues = new MutablePropertyValues();
        pValues.add("category", "猫科");
        //这个是给 Animal 中各个属性设置值的
        pbd.setPropertyValues(pValues);
        ctx.registerBeanDefinition("parent", pbd);
        GenericBeanDefinition cbd = new GenericBeanDefinition();
        cbd.setBeanClass(Cat.class);
        MutablePropertyValues cValues = new MutablePropertyValues();
        cValues.add("name", "小花");
        cValues.add("color", "五颜六色");
        cbd.setPropertyValues(cValues);
        cbd.setParentName("parent");
        ctx.registerBeanDefinition("child",cbd);
        ctx.refresh();
        Cat cat = ctx.getBean(Cat.class);
        System.out.println("cat = " + cat);
    }
}
