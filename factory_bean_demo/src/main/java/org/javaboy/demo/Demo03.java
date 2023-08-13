package org.javaboy.demo;

import okhttp3.OkHttpClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//        OkHttpClient client = ctx.getBean("okHttpClient3",OkHttpClient.class);
//        OkHttpClient client2 = ctx.getBean("okHttpClient3",OkHttpClient.class);
//        System.out.println("client2 = " + client2);
//        System.out.println(client2==client);
        Object bean = ctx.getBean("&okHttpClient3");
        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
