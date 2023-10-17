package org.javaboy.demo;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class DemoMessageFormat {
    public static void main(String[] args) {
        //根据语言和国家/地区构建 Locale 对象
        Locale localeZhCN = new Locale("zh", "CN");
        //baseName 就是基本的配置文件名，这个是 content
        ResourceBundle contentZhCN = ResourceBundle.getBundle("content", localeZhCN);
        String info = contentZhCN.getString("info");
        MessageFormat mf = new MessageFormat(info);
        Object[] arguments = new Object[]{"javaboy","Spring源码"};
        String format = mf.format(arguments);
        System.out.println("format = " + format);
    }
}
