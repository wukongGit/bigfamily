package com.sunc.mapper;

import com.sunc.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by suncheng on 2018/8/7.
 */
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User loadUserByUsername(String username);

    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    int insert(@Param("username") String username, @Param("password") String password);
}
