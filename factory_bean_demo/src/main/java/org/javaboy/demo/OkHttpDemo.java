package org.javaboy.demo;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class OkHttpDemo {
    public static void main(String[] args) throws InterruptedException {
        //通过建造者模式去创建 OkHttpClient 对象
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        //构建一个具体的请求
        Request getRequest = new Request.Builder()
                .get()
                .url("http://www.javaboy.org")
                .build();
        Call call = client.newCall(getRequest);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //执行网络请求，处理请求结果
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //减一
                countDownLatch.countDown();
            }

            /**
             * 这个就是请求成功的回调函数
             * @param call
             * @param response
             * @throws IOException
             */
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //减一
                countDownLatch.countDown();
                System.out.println("response.body().string() = " + response.body().string());
            }
        });
        //会判断计数器是否为 0，如果为 0，才会继续执行后续的代码，否则就暂停在这里
        countDownLatch.await();
    }
}
