package com.echo.restaurant.config.auth.security;


import com.echo.restaurant.config.auth.MyUserDetailsService;
import com.echo.restaurant.config.auth.jwt.JwtAuthenticationFilter;
import com.echo.restaurant.config.auth.jwt.JwtConfig;
import com.echo.restaurant.config.auth.jwt.JwtTokenVerifier;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

import static com.echo.restaurant.constant.AppConstant.WHITE_LIST_URL;

@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final MyUserDetailsService userDetailsService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()                           // making session stateless, No session will be created or used by spring security
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(jwtConfig, secretKey), JwtAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(WHITE_LIST_URL).permitAll()
                .anyRequest()
                .authenticated();
    }


    // Here we configure authentication provider for database connectivity, DaoAuthenticationProvider is one of the implementation of the AuthenticationManager.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);

        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

        auth.authenticationProvider(provider);
    }
}
