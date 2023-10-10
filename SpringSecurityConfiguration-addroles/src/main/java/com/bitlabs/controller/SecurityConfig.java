package com.bitlabs.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("Bhagya")
            .password(getPasswordEncoder().encode("Sree"))
            .roles("admin_role")
            .and()
            .withUser("Ritvik")
            .password(getPasswordEncoder().encode("dhanu"))
            .roles("student_role");
    }

    @SuppressWarnings({ "deprecation", "removal" })
	protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/delete").hasRole("admin_role")
                .and()
            .httpBasic()
                .and()
            .formLogin();
    }

    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder getPasswordEncoder(){ 
        return NoOpPasswordEncoder.getInstance(); 
    } 
}

