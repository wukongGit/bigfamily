package com.sunc.mapper;

import com.sunc.bean.Member;
import com.sunc.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by suncheng on 2018/8/7.
 */
public interface MemberMapper {

    @Select("SELECT * FROM member")
    List<Member> getAllMembers();

    @Select("SELECT * FROM member WHERE username = #{username}")
    Member loadMemberByUsername(String username);

    @Select("SELECT * FROM user WHERE username = #{username} and password = #{password}")
    Member findByUsernameAndPassword(String username, String password);
}
