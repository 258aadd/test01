package com.ml.mapper;

import com.ml.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    User getUserByName(String username);

    @Select("select * from user where uname=#{uname} and password=#{pwd}")
    User login(@Param("uname") String username,@Param("pwd") String password) throws Exception;
}
