package org.javaboy.demo;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public aspect TxAspect {
    void around():call(void MoneyService.transferMoney()){
        try {
            System.out.println("开启事务");
            //表示让业务方法去执行，即执行 MoneyService.transferMoney() 方法
            proceed();
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
        }
    }
}
