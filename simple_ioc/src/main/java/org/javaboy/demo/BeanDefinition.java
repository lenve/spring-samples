package org.javaboy.demo;

/**
 * 这个类用来记录 Bean 的定义，即将 JSON 中的内容解析出来，封装成一个 BeanDefinition 对象
 * （Spring 中是将 XML 或者 Java 配置的内容解析出来，封装成一个 BeanDefinition）
 */
public class BeanDefinition {
    private String clazz;
    private String id;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
