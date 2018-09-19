package com.sunc.security;

import com.sunc.bean.Member;
import com.sunc.bean.User;
import com.sunc.mapper.MemberMapper;
import com.sunc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suncheng on 2018/8/7.
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不对");
        }

        return user;
    }

    public int addUser(String username, String password) {
        return userMapper.insert(username, password);
    }

    public List<Member> getAllMembers() {
        return memberMapper.getAllMembers();
    }
}
