package com.sunc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suncheng on 2018/8/2.
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello family";
    }
}
