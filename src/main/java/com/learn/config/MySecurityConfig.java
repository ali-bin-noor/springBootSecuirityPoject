package com.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
     http
             .authorizeRequests()
             .antMatchers("/public/**").hasRole("NORMAL")
             .antMatchers("/users/**").hasRole("ADMIN")
             .anyRequest()
             .authenticated()
             .and()
             .httpBasic();
    }

    //assigning custom username ,password and roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication().withUser("root").password(this.passwordEncoder().encode("root")).roles("NORMAL");
        auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN","NORMAL");
    }
    //Role-High Level Overview ->Normal :READ
    //Authority - permission- READ
    //ADMIN-READ,WRITE AND UPDATE



    //Encrypting the password
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }
}
