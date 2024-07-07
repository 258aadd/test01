package com.ml.service.impl;

import com.ml.mapper.GradeMapper;
import com.ml.mapper.StudentMapper;
import com.ml.pojo.Grade;
import com.ml.pojo.Student;
import com.ml.service.StudentService;
import com.ml.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getStudentList() {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getStudentList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public List<Student> getStudentList2() throws Exception {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
            List<Student> students = studentMapper.getStudentAll();
            for (Student student : students) {
                Integer gid = student.getGid();
                Grade grade = gradeMapper.getGradeById(gid);
                student.setGrade(grade);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.addStudent(student);
            sqlSession.commit();
            return true;
        } catch (SQLException e) {
            sqlSession.rollback();
            throw new RuntimeException(e);

        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    @Override
    public boolean checkName(String name) {
        try {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int count = studentMapper.checkName(name);
            return count <= 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession();
        }
        return false;
    }
}
