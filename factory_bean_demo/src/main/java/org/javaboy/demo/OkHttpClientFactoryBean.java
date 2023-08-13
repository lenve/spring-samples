package org.javaboy.demo;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.TimeUnit;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 *
 * 注意这个命名是有规则的，一般叫做 xxxFactoryBean，看到这个名字，就知道最终生成的 Bean 实际上是 xxx
 */
public class OkHttpClientFactoryBean implements FactoryBean<OkHttpClient> {
    /**
     * 返回具体的实例对象
     * @return
     * @throws Exception
     */
    @Override
    public OkHttpClient getObject() throws Exception {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 返回的实例对象的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return OkHttpClient.class;
    }

    /**
     * 是否是单例模式
     * 如果为 false，就相当于 scope 为 prototype，默认该值为 true
     * @return
     */
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
