package com.arproject.arproject.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//          @formatter: off
                        //TODO: MAKE SURE ALL ROUTES ARE CORRECTED WITH && ACCOUNTING FOR ONLY SPECIFIC USER ID
            http
                .authorizeRequests()
                    .antMatchers("/", "/Login", "/SignUp").permitAll()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/user").hasRole("USER")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/Login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/loggedout");
//            @formatter:on
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("SELECT useremail, userpass, userenabled FROM uzer WHERE useremail = ?")
                .authoritiesByUsernameQuery("SELECT useremail, userauth FROM uzer WHERE useremail = ?");
    }
}
