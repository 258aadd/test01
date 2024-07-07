package com.ml.service.impl;

import com.ml.mapper.UserMapper;
import com.ml.pojo.User;
import com.ml.service.UserService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {
        try{
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        SqlSession sqlSession = null;
        sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByName(username);
        MybatisUtil.closeSqlSession();
        return user;
    }
}
