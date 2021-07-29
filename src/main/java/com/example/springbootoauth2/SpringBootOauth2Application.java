package com.example.springbootoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import tk.mybatis.spring.annotation.MapperScan;

@EnableAuthorizationServer
@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@MapperScan(value = "com.example.springbootoauth2.mapper")
public class SpringBootOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOauth2Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //token准换器
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("lrc-wzx");
        return jwtAccessTokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(){
        JwtTokenStore jwtTokenStore=new JwtTokenStore(jwtAccessTokenConverter());
        return jwtTokenStore;
    }

}
