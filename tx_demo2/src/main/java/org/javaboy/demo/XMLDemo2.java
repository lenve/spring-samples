package org.javaboy.demo;

import org.javaboy.demo.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class XMLDemo2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans2.xml");
        AccountService as = ctx.getBean(AccountService.class);
        System.out.println("as.getClass() = " + as.getClass());
        as.transferMoney("zhangsan", "lisi", 100.0);
    }
}
