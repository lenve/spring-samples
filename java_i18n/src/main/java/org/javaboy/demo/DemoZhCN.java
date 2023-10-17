package org.javaboy.demo;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class DemoZhCN {
    public static void main(String[] args) {
        //根据语言和国家/地区构建 Locale 对象
        Locale localeZhCN = new Locale("zh", "CN");
        //baseName 就是基本的配置文件名，这个是 content
        ResourceBundle contentZhEN = ResourceBundle.getBundle("content", localeZhCN);
        String name = contentZhEN.getString("name");
        System.out.println("name = " + name);
    }
}
