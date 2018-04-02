package com.linzy.module.sys.controller;

import com.linzy.common.util.HttpResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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

    /**
     * 进行登陆
     * @param request
     * @param resp
     * @param username
     * @param password
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse resp,String username,String password) {
        //验证
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //获取当前的Subject
        Subject subject = SecurityUtils.getSubject();
        try{
            //进行登陆,开始验证
            subject.login(token);
            //验证通过
        }catch (UnknownAccountException uae){
            //验证未通过,未知账户"
        }catch (IncorrectCredentialsException ice){
            //验证未通过,错误的凭证(密码不正确)
        }catch (LockedAccountException lae){
            //验证未通过,账户已锁定
        }catch(ExcessiveAttemptsException eae){
            //验证未通过,错误次数大于5次,账户已锁定
        }catch (DisabledAccountException sae){
            //验证未通过,帐号已经禁止登录
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            //验证未通过,堆栈轨迹如下,用户名或密码不正确"
        }
        //验证是否登录成功
        if(subject.isAuthenticated()){
            //登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)
        }else{
            token.clear();
        }
    }
}
