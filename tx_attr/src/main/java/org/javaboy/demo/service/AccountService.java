package org.javaboy.demo.service;

import org.javaboy.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

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

    @Autowired
    AccountService2 accountService2;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,noRollbackFor = ArithmeticException.class,readOnly = true,timeout = 60000)
    public void transferMoney(String from, String to, Double money) throws IOException {
        accountDao.minusMoney(from, money);
        //savePoint
//        try {
            accountService2.addMoney(to, money);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        int i = 1 / 0;
//        throw new IOException("xxx");
    }

}
