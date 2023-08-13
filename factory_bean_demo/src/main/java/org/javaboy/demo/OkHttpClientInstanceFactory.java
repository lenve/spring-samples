package org.javaboy.demo;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class OkHttpClientInstanceFactory {
    private static OkHttpClient okHttpClient;

    static {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public OkHttpClient getInstance() {
        return okHttpClient;
    }
}
