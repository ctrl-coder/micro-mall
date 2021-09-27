package com.mall.config;

import com.mall.handler.MallAuthenticationFailureHandler;
import com.mall.handler.MallAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Order(2)
@Configuration
@EnableResourceServer
public class MallResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MallAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private MallAuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()  // 表单登录
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication")
                .successHandler(authenticationSuccessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/authentication/require", "/admin/register").permitAll()
                .anyRequest()    // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable();
    }
}
