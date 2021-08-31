package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserMapperTest {
    /**
     * sqlSessionFactory是单例的. 一个数据库只有一个SqlSessionFactory对象实例
     */
    static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws Exception{
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void saveUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 获取UserMapper实现类
            UserMapper userMapper = session.getMapper(UserMapper.class);

            User user = new User(null,"ddee" , 1);

            System.out.println(userMapper.saveUser(user));

            System.out.println(user);

            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void updateUserById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 获取UserMapper实现类
            UserMapper userMapper = session.getMapper(UserMapper.class);

            User user = new User(7,"bbj" , 0);

            userMapper.updateUserById(user);

            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void deleteUserById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 获取UserMapper实现类
            UserMapper userMapper = session.getMapper(UserMapper.class);

            User user = new User(7,"bbj" , 0);

            userMapper.deleteUserById(8);

            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void queryUserById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 获取UserMapper实现类
            UserMapper userMapper = session.getMapper(UserMapper.class);

            System.out.println(userMapper.queryUserById(9));

        } finally {
            session.close();
        }
    }

    @Test
    public void queryUsers() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 获取UserMapper实现类
            UserMapper userMapper = session.getMapper(UserMapper.class);

            userMapper.queryUsers().forEach(System.out::println);

        } finally {
            session.close();
        }
    }
}