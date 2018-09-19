package com.sunc.security;

import com.sunc.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by suncheng on 2018/8/7.
 */
public class UserUtils {
    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
