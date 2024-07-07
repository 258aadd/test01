package com.ml.mapper;

import com.ml.pojo.Grade;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GradeMapper {
    @Select("select  * from grade where gid = #{id}")
    Grade getGradeById(int id);

    @Select("select * from grade")
    List<Grade> getGradeList();
}
