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
public class DemoDefault {
    public static void main(String[] args) {
        //根据语言和国家/地区构建 Locale 对象
        Locale localeZhCN = new Locale("zh", "HK");
        //baseName 就是基本的配置文件名，这个是 content，如果不指定 locale，则展示的就是默认字符串
        //或者配置的 locale 本地实际上并不存在，此时也展示的是默认的信息
        ResourceBundle contentZhEN = ResourceBundle.getBundle("content",localeZhCN);
        String name = contentZhEN.getString("name");
        System.out.println("name = " + name);
    }
}
