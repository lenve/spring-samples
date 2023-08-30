package org.javaboy.demo;

import org.javaboy.demo.model.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class XMLDemo {
    public static void main(String[] args) {
        //首先创建一个容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //此时这个容器是空的，里边没有任何 Bean
        //这个单纯就只是一个 XML 文件的加载工具，创建对象时，传入 BeanFactory，因为 XML 文件加载完成之后，要把 Bean 注册到容器中去，注册到 beanFactory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //加载配置文件，这个方法最终会触发 XML 文件解析，将 Bean 读取出来并注册到 beanFactory 中
        reader.loadBeanDefinitions("beans.xml");
        User user = beanFactory.getBean("user", User.class);
        System.out.println("user = " + user);
    }
}
