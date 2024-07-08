package com.ml.mapper;

import com.ml.pojo.Doctors;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface DoctorsMapper {

    @Select("select * from doctor where job_number = #{uname} and password = #{password}")
    Doctors login(@Param("uname") String name, @Param("password") String password) throws SQLException;
}
