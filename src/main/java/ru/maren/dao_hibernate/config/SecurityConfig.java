package ru.maren.dao_hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Vadim").password("{noop}pass").authorities("read", "write", "delete")
                .and()
                .withUser("Anya").password("{noop}pass").authorities("read")
                .and()
                .withUser("Max").password("{noop}pass").authorities("read", "write");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/hi").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/save").hasAuthority("write")
                .and()
                .authorizeRequests().antMatchers("/persons/delete").hasAuthority("delete")
                .and()
                .authorizeRequests().anyRequest().hasAuthority("read");
        ;
    }
}
