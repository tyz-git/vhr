package org.javaboy.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.security.auth.login.CredentialException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //所有接口必须认证通过后才可以访问  
                .anyRequest().authenticated()
                .and()
                //表单登录设置
                .formLogin()
                //登录时用户名的变量名
                .usernameParameter("username")
                //登录时密码的变量名
                .passwordParameter("password")
                //登录功能地址
                .loginProcessingUrl("/doLogin")
                //登录页面为login
                .loginPage("/login")
                //登录成功的处理(由于前后端分离，所以需要把响应数据处理成json再返回，而不是登录成功后服务端直接跳转页面)
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
                        //设置响应中实体数据(body)的类型
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        //返回登录成功的用户信息
                        Hr hr = (Hr) auth.getPrincipal();
                        //封装响应数据
                        RespBean ok = RespBean.success("登录成功", hr);
                        //将通用返回结果转化成字符串
                        String s = new ObjectMapper().writeValueAsString(ok);
                        //写出去
                        out.write(s);
                        //刷新
                        out.flush();
                        //关流
                        out.close();

                    }
                })
                //登录失败的处理
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
                        //设置响应中实体数据(body)的类型
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        //封装响应数据
                        RespBean error = RespBean.error("登录失败");
                        if (exception instanceof LockedException){
                            error.setMsg("账户被锁定，请联系管理员!");
                        }else if (exception instanceof DisabledException){
                            error.setMsg("账户被禁用，请联系管理员!");
                        }else if (exception instanceof CredentialsExpiredException){
                            error.setMsg("密码过期，请联系管理员!");
                        }else if (exception instanceof AccountExpiredException){
                            error.setMsg("账户过期，请联系管理员!");
                        }else if (exception instanceof BadCredentialsException){
                            error.setMsg("用户名或密码输入错误，请联系管理员!");
                        }
                        //把响应的数据转化成字符串
                        String s = new ObjectMapper().writeValueAsString(error);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                //和表单登录相关的接口直接放行
                .permitAll()
                .and()
                //退出登录
                .logout()
                //退出登录成功的处理
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

                    }
                })
                //和退出登录功能相关的接口直接放行
                .permitAll()
                .and()
                //取消对csrf的防御
                .csrf().disable();
    }
}
