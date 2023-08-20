package org.javaboy.demo.service;

import org.javaboy.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
    PlatformTransactionManager transactionManager;

    @Autowired
    TransactionTemplate transactionTemplate;

    public void transferMoney(String from, String to, Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    accountDao.minusMoney(from, money);
//                    int i = 1 / 0;
                    accountDao.addMoney(to, money);
                } catch (Exception e) {
                    status.setRollbackOnly();
                }
            }
        });

    }

    public void transferMoney2(String from, String to, Double money) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            accountDao.minusMoney(from, money);
//            int i = 1 / 0;
            accountDao.addMoney(to, money);
            //提交事务
            transactionManager.commit(status);
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollback(status);
        }
    }
}
