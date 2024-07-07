package com.ml.mapper;

import com.ml.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface StudentMapper {

    List<Student> getStudentList() throws SQLException;

    List<Student> getStudentAll() throws SQLException;

    @Insert("insert into student(sname, age, gender, gid) values (#{sname}, #{age}, #{gender}, #{gid})")
    int addStudent(Student student) throws SQLException;

    @Select("select count(sid) from student where sname = #{name}")
    int checkName(@Param("name") String name) throws SQLException;
}
