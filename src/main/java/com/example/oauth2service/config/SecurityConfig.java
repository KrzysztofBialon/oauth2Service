package com.example.oauth2service.config;

import com.example.oauth2service.handler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    CustomSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http.authorizeRequests().anyRequest().authenticated().and().oauth2Login().successHandler(successHandler);
    }
}
