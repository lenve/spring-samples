package org.javaboy.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, Object> container = new HashMap<>();
        ObjectMapper om = new ObjectMapper();
        List<BeanDefinition> beanDefinitions = om.readValue(Demo01.class.getResourceAsStream("/beans.json"), new TypeReference<List<BeanDefinition>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        for (BeanDefinition bd : beanDefinitions) {
            String id = bd.getId();
            String clazz = bd.getClazz();
            //获取到类的全路径，调用构造方法，获取实例
            Object instance = Class.forName(clazz).getConstructor().newInstance();
            container.put(id, instance);
        }
        Dog dog = (Dog) container.get("dog");
        System.out.println("dog = " + dog);
    }
}
