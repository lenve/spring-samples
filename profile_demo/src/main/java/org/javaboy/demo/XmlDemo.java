package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class XmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().addActiveProfile("prod");
        ctx.setConfigLocations("beans.xml");
        ctx.refresh();
        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println("ds = " + ds);

    }
}
