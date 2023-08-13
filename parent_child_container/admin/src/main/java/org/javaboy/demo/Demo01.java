package org.javaboy.demo;

import org.javaboy.consumer.RoleService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        //不允许 bean 覆盖
        ctx.setAllowBeanDefinitionOverriding(false);
        ctx.setConfigLocations("consumer.xml","merchant.xml");
        ctx.refresh();
//        org.javaboy.merchant.RoleService r2 = ctx.getBean(org.javaboy.merchant.RoleService.class);
//        System.out.println("r2 = " + r2);
//        RoleService r1 = ctx.getBean(RoleService.class);
//        System.out.println("r1 = " + r1);
    }
}
