package com.ml.service.impl;

import com.ml.mapper.AdminsMapper;
import com.ml.pojo.Admins;
import com.ml.service.AdminsService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class AdminsServiceImpl implements AdminsService {

    @Override
    public Admins login(String name, String password) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            AdminsMapper adminsMapper = sqlSession.getMapper(AdminsMapper.class);
            return adminsMapper.login(name, password);
        } catch (SQLException e) {
            MybatisUtil.closeSqlSession();
        } finally {
            return null;
        }
    }
}
