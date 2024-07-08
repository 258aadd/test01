package com.ml.service.impl;

import com.ml.mapper.DoctorsMapper;
import com.ml.pojo.Doctors;
import com.ml.service.DoctorsService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class DoctorsServiceImpl implements DoctorsService {
    @Override
    public Doctors login(String name, String password) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);
            return doctorsMapper.login(name, password);
        } catch (SQLException e) {
            MybatisUtil.closeSqlSession();
        } finally {
            return null;
        }
    }
}
