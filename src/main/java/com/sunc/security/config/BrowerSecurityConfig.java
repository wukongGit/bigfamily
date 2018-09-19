package com.sunc.security.config;

import com.sunc.constants.SecurityConstants;
import com.sunc.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by suncheng on 2018/8/7.
 */
@Configuration
public class BrowerSecurityConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private UserService userService;

    /**
     * 数据库连接池
     */
    @Autowired
    private DataSource dataSource;




    @Bean
    public PersistentTokenRepository persisentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //      tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);
        http
                //   .httpBasic()  //使用弹出框进行身份认证
//                .apply(validateCodeSecurityConfig)
//                .and()
//                .apply(smsCodeAuthenticationSecurityConfig)
//                .and()
//                .apply(gwfSocialConfigurer)
//                .and()
//                .rememberMe()
//                .tokenRepository(persisentTokenRepository())
//                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
//                .userDetailsService(userDetailsService)
//                .and()
//                .sessionManagement()
//                .invalidSessionStrategy(invalidSessionStrategy)
//                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
//                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
//                .expiredSessionStrategy(sessionInformationExpiredStrategy)
//                .and()
//                .and()
//                .logout()
//                .logoutUrl("/signOut")
//                .logoutSuccessHandler(logoutSuccessHandler)
//                .deleteCookies("JSESSIONID")
//                .and()
                .authorizeRequests()    //认证的request authentication
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_REGISTER_PROCESSING_URL_FORM,
                        SecurityConstants.DEFAULT_LOGIN_PAGE_URL)
                .permitAll()
                .anyRequest()          //所有请求
                .authenticated()       //都需要认证
                .and()
                .csrf().disable();     //禁止跨站拦截
    }
}
