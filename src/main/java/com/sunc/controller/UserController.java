package com.sunc.controller;

import com.sunc.security.UserService;
import com.sunc.model.Result;
import com.sunc.model.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by suncheng on 2018/8/2.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public Result members() {
        return ResultGenerator.genSuccessResult(userService.getAllMembers());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(String username, String password) {
        return ResultGenerator.genSuccessResult(userService.addUser(username, password));
    }

}
