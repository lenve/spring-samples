package org.javaboy.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class DemoDateFormat {
    public static void main(String[] args) {
        //根据语言和国家/地区构建 Locale 对象
        Locale localeEnUS = new Locale("en", "US");
        Locale localeZhCN = new Locale("zh", "CN");
        DateFormat diEnUS = DateFormat.getDateInstance(DateFormat.LONG, localeEnUS);
        DateFormat diZhCN = DateFormat.getDateInstance(DateFormat.LONG, localeZhCN);
        System.out.println("diEnUS.format(new Date()) = " + diEnUS.format(new Date()));
        System.out.println("diZhCN.format(new Date()) = " + diZhCN.format(new Date()));
    }
}
