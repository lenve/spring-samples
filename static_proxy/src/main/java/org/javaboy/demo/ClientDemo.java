package org.javaboy.demo;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class ClientDemo {
    public static void main(String[] args) {
        HouseAgent houseAgent = new HouseAgent(new LandLord());
        houseAgent.rent();
    }
}
