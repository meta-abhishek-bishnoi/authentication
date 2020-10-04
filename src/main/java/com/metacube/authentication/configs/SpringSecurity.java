package com.metacube.authentication.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
  @Autowired
  DataSource dataSource;
  
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/Image/**","/css/**","/js/**");
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/home").hasAnyRole("USER", "ADMIN")
        .antMatchers("/user/**").hasAnyRole("USER","ADMIN")
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .anyRequest().authenticated().and().formLogin()
        .permitAll().defaultSuccessUrl("/home").failureUrl("/login?error=true").
        and().logout().permitAll();
    
    http.csrf().disable();
  }
  
  @SuppressWarnings("deprecation")
  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).dataSource(dataSource);
  }
}
