package org.javaboy.demo;

import org.javaboy.consumer.RoleService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext consumerContainer = new ClassPathXmlApplicationContext("consumer.xml");
        ClassPathXmlApplicationContext merchantContainer = new ClassPathXmlApplicationContext("merchant.xml");
        merchantContainer.setParent(consumerContainer);
        merchantContainer.refresh();
        RoleService r1 = consumerContainer.getBean(RoleService.class);
        org.javaboy.merchant.RoleService r2 = merchantContainer.getBean(org.javaboy.merchant.RoleService.class);
        RoleService r3 = merchantContainer.getBean(RoleService.class);
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        String[] s1 = merchantContainer.getBeanNamesForType(RoleService.class);
        String[] s2 = merchantContainer.getBeanNamesForType(org.javaboy.merchant.RoleService.class);
        System.out.println("Arrays.toString(s1) = " + Arrays.toString(s1));
        System.out.println("Arrays.toString(s2) = " + Arrays.toString(s2));
    }
}
