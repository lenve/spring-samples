package org.javaboy.demo;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class DemoNumberFormat {
    public static void main(String[] args) {
        //根据语言和国家/地区构建 Locale 对象
        Locale localeEnUS = new Locale("en", "US");
        Locale localeZhCN = new Locale("zh", "CN");
        NumberFormat ciEnUS = NumberFormat.getCurrencyInstance(localeEnUS);
        NumberFormat ciZhCN = NumberFormat.getCurrencyInstance(localeZhCN);
        String formatEnUS = ciEnUS.format(99);
        String formatZhCN = ciZhCN.format(99);
        System.out.println("formatZhCN = " + formatZhCN);
        System.out.println("formatEnUS = " + formatEnUS);
    }
}
