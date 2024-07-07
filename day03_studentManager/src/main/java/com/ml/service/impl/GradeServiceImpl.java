package com.ml.service.impl;

import com.ml.mapper.GradeMapper;
import com.ml.pojo.Grade;
import com.ml.service.GradeService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GradeServiceImpl implements GradeService {
    @Override
    public List<Grade> getGradeList() {
        try {
            SqlSession sqlSession = null;
            sqlSession = MybatisUtil.getSqlSession();
            GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
            return gradeMapper.getGradeList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }
}
