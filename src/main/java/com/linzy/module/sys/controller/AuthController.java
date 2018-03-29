package com.linzy.module.sys.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证接口
 * @author zhiyong.lin
 * @version 2018/3/29 11:35
 */
@RestController
@RequestMapping(value = "/sys/auth")
public class AuthController {

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse resp) {
        return "sdfsf";
    }
}
