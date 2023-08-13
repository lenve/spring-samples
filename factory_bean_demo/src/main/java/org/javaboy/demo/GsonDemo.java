package org.javaboy.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class GsonDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("javaboy");
        user.setBirthday(new Date());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        System.out.println("gson.toJson(user) = " + gson.toJson(user));
    }

}
