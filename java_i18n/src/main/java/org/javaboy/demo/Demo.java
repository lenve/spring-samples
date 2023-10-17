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
public class Demo {
    public static void main(String[] args) {
        //根据语言和国家/地区构建 Locale 对象
        Locale localeEnUS = new Locale("en", "US");
        //baseName 就是基本的配置文件名，这个是 content
        ResourceBundle contentEnUS = ResourceBundle.getBundle("content", localeEnUS);
        String name = contentEnUS.getString("name");
        System.out.println("name = " + name);
    }
}
