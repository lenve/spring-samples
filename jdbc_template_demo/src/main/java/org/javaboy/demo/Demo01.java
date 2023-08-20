package org.javaboy.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author：江南一点雨
 * @site：http://www.javaboy.org
 * @微信公众号：江南一点雨
 * @github：https://github.com/lenve
 * @gitee：https://gitee.com/lenve
 */
public class Demo01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
        //这个一般是执行 DDL 操作
//        jdbcTemplate.execute();
        //如果有批处理需要执行，调用这个方法
//        jdbcTemplate.batchUpdate()
        //增删改都是调用这个方法
//        jdbcTemplate.update()
        //下面都是查询的方法
//        jdbcTemplate.query();
//        jdbcTemplate.queryForList();
//        jdbcTemplate.queryForObject();
//        add(jdbcTemplate);
//        update(jdbcTemplate);
//        delete(jdbcTemplate);
//        query(jdbcTemplate);
//        query2(jdbcTemplate);
//        query3(jdbcTemplate);
//        query4(jdbcTemplate);
//        query5(jdbcTemplate);
//        query6(jdbcTemplate);
        query7(namedParameterJdbcTemplate);
    }

    private static void query7(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("address", "shenzhen");
        List<User> list = namedParameterJdbcTemplate.query("select * from user where id>:id and address=:address", map, new BeanPropertyRowMapper<>(User.class));
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    private static void query6(JdbcTemplate jdbcTemplate) {
        // queryForList 函数，要求查询结果也是只能有一列
        List<String> users = jdbcTemplate.queryForList("select name from user", String.class);
        for (String user : users) {
            System.out.println("user = " + user);
        }
    }

    private static void query5(JdbcTemplate jdbcTemplate) {
        //注意，第二个参数如果是一些普通对象的话，要求查询结果只能有一列
        String user = jdbcTemplate.queryForObject("select name from user where id=?", String.class, 2);
        System.out.println("user = " + user);
    }

    private static void query4(JdbcTemplate jdbcTemplate) {
        User user = jdbcTemplate.queryForObject("select * from user where id=?", new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println("user = " + user);
    }

    private static void query3(JdbcTemplate jdbcTemplate) {
        //BeanPropertyRowMapper 会自动将查询结果映射到对象上，但是有一个前提，就是查询的结果的列名称必须和对象的属性名称保持一致
        List<User> list = jdbcTemplate.query("select * from user where address=?", new BeanPropertyRowMapper<>(User.class), "shenzhen");
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    private static void query2(JdbcTemplate jdbcTemplate) {
        List<User> list = jdbcTemplate.query("select * from user where address=?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        }, "shenzhen");
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    private static void query(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.query("select * from user where address=?", new RowCallbackHandler() {
            /**
             * 这里的 processRow 这个方法已经位于一个 while(rs.next()) 中了，所以我们只需要处理 rs 即可，不需要继续往后遍历
             * @param rs
             * @throws SQLException
             */
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(id + "-" + name + "-" + address);
            }
        }, "shenzhen");
    }

    private static void delete(JdbcTemplate jdbcTemplate) {
        int update = jdbcTemplate.update("delete from user where id=?;", 1);
        System.out.println("update = " + update);
    }

    private static void update(JdbcTemplate jdbcTemplate) {
        int i = jdbcTemplate.update("update user set address = ? where id=?;", "广州", 1);
        System.out.println("i = " + i);
    }

    private static void add(JdbcTemplate jdbcTemplate) {
        //返回值就是数据库受影响的行数
        int i = jdbcTemplate.update("insert into user (name,address) values (?,?);", "javaboy", "深圳");
        System.out.println("i = " + i);
    }
}
