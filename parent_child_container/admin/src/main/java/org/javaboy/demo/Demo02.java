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
public class Demo02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext parent = new ClassPathXmlApplicationContext();
        parent.refresh();
        ClassPathXmlApplicationContext consumerContainer = new ClassPathXmlApplicationContext("consumer.xml");
        ClassPathXmlApplicationContext merchantContainer = new ClassPathXmlApplicationContext("merchant.xml");
        consumerContainer.setParent(parent);
        merchantContainer.setParent(parent);
        RoleService r1 = consumerContainer.getBean(RoleService.class);
        org.javaboy.merchant.RoleService r2 = merchantContainer.getBean(org.javaboy.merchant.RoleService.class);
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
    }
}
