package org.javaboy.demo.service;

import org.javaboy.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Service
public class AccountService2 {
    @Autowired
    AccountDao accountDao;


    @Transactional(propagation = Propagation.REQUIRED)
    public void addMoney(String to, Double money) {
        accountDao.addMoney(to, money);
//        int i = 1 / 0;
    }
}
