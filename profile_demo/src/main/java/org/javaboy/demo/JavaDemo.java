package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class JavaDemo {
    public static void main(String[] args) {
        //这里注意，不能添加配置类，如果添加了配置类，则 refresh 方法会被调用，而 Spring 容器的初始化则正是从这里开始的
        //此时，我们还没设置当前系统环境
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //这里需要先设置系统环境，然后再去启动容器
        //这个表示设置当前系统环境为 dev
        ConfigurableEnvironment env = ctx.getEnvironment();
        env.addActiveProfile("prod");
        //此时再去设置配置类
        ctx.register(JavaConfig.class);
        //开始初始化容器
        ctx.refresh();
        DataSource ds1 = ctx.getBean("prodDataSource",DataSource.class);
        System.out.println("ds1 = " + ds1);
    }
}
