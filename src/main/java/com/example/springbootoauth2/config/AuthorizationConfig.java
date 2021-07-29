package com.example.springbootoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 授权服务配置
 * 生成授权码
 * 生成令牌token
 */
//@Configuration
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    /*@Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    *//**
     * token令牌存放位置
     * @return
     *//*
    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    *//*
     * 客户端配置
     * @param clients
     * @throws Exception
     *
     *//*

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //授权码模式获取token
        clients.inMemory()
                .withClient("web")
                .secret(passwordEncoder.encode("secret"))
                .scopes("all")
                .authorizedGrantTypes("authorization_code")
                .accessTokenValiditySeconds(7200)
                .redirectUris("http://localhost:8080/user/login")
                .and()
                //密码模式获取token
                .inMemory()
                .withClient("qq").secret(passwordEncoder.encode("qq:secret"))
                .authorizedGrantTypes("password")
                .accessTokenValiditySeconds(7200)
                .scopes("red")
                .redirectUris("https://www.baidu.com")
                .and()
                 //客户端模式获取token
                 .inMemory()
                .withClient("wechat").secret(passwordEncoder.encode("wechat:secret"))
                .authorizedGrantTypes("client_credentials")
                .accessTokenValiditySeconds(7200)
                .scopes("write")
                .redirectUris("https://www.baidu.com");
    }


    *//*
     * 允许获取令牌请求，校验令牌请求通过
     * @param security
     * @throws Exception
     *//*

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager);
    }
*/
    //http://localhost:8080/oauth/authorize?client_id=web&response_type=code&redirect_uri=http://localhost:8080/user/login&client_secret=secret

}



