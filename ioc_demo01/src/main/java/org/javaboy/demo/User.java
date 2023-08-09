package org.javaboy.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class User {
    private String name;
    private String address;
    private Integer age;

    private Dog dog;

    private String[] favorites;

    private List<Cat> cats;

    private Map<String, Object> info;

    private Properties job;

    public User() {
    }

    public User(String name, String address, Integer age, Dog dog, String[] favorites, List<Cat> cats, Map<String, Object> info, Properties job) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.dog = dog;
        this.favorites = favorites;
        this.cats = cats;
        this.info = info;
        this.job = job;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                ", favorites=" + Arrays.toString(favorites) +
                ", cats=" + cats +
                ", info=" + info +
                ", job=" + job +
                '}';
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public Properties getJob() {
        return job;
    }

    public void setJob(Properties job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
