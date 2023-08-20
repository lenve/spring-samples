package org.javaboy.demo.service;

import org.javaboy.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;

    //给当前方法添加事务
    @Transactional
    public void transferMoney(String from, String to, Double money) {
        accountDao.minusMoney(from, money);
//        int i = 1 / 0;
        accountDao.addMoney(to, money);
    }

}
