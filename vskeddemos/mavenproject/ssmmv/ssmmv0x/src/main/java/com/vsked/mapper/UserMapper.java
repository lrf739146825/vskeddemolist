package com.vsked.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.vsked.model.User;

public interface UserMapper {
    
    @Insert("INSERT INTO userinfo(username, password) VALUES(#{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR})")
    public int insertUser(Map<String, Object> user);
    
    @Select("SELECT * FROM userinfo WHERE username = #{username} AND password = #{password}")
    @Results(value = { @Result(id = true, column = "id", property = "id"),
                       @Result(column = "username", property = "username"), 
                       @Result(column = "password", property = "password")})
    public User selectByUsernameAndPwd(@Param("username")String username ,@Param("password")String password);
}
