package com.linzy.common.shiro.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 登陆拦截器
 * @author zhiyong.lin
 * @version 2018/4/2 10:20
 */
public class LoginFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if(null != subject && subject.isAuthenticated()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //保存Request和Response 到登录后的链接
        /* saveRequestAndRedirectToLogin(request, response);*/
        return Boolean.FALSE ;
    }
}
