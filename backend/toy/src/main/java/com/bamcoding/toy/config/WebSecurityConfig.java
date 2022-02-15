package com.bamcoding.toy.config;

import com.bamcoding.toy.security.JwtAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors()
            .and()
            .csrf()
                .disable() // csrf 를 사용하지 않는다.
            .httpBasic()
                .disable() // basic 인증을 사용하지 않는다.
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
                .antMatchers("/","/auth/**","/test/**").permitAll()
            .anyRequest()
                .authenticated();

        // filter 등록
        // 매 요청마다 CorsFilter 실행한 후에 jwtAuthenticationFilter 실행한다.
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
    }
}
