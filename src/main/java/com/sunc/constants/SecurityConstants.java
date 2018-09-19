package com.sunc.constants;

/**
 * Created by suncheng on 2018/8/7.
 */
public class SecurityConstants {
    /**
     * 当请求需要身份认证时，默认跳转的url
     */
    public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    /**
     * 默认的用户名密码登录请求处理url
     */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
    /**
     * 默认登录页面
     */
    public static final String DEFAULT_LOGIN_PAGE_URL = "/my-signIn.html";
    /**
     * 默认的用户名密码注册请求处理url
     */
    public static final String DEFAULT_REGISTER_PROCESSING_URL_FORM = "/user/register";
}
