package org.javaboy.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
@Repository
public class AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMoney(String username, Double money) {
        jdbcTemplate.update("update account set money = money+? where username=?;", money, username);
    }
    public void minusMoney(String username, Double money) {
        jdbcTemplate.update("update account set money = money-? where username=?;", money, username);
    }
}
