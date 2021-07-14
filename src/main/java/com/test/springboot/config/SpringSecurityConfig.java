package com.test.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        // auth.inMemoryAuthentication()
                // .withUser("admin").password("123456").roles("USER");

        // Spring boot 2.0.3以及以后的引用的security 依赖是 spring security 5.X版本
        // 此版本需要提供一个PasswordEncorder的实例，创建一个MyPasswordEncoder进行使用
        // .passwordEncoder(new MyPasswordEncoder())这样提交的时候就是明文提交，就不会报错
        auth.inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())
                .withUser("admin").password("123456").roles("USER");
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //所有都放行
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//                .and().csrf().disable();
//    }

}
