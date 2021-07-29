package com.example.springbootoauth2.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 客户端实体类传递
 */
public class Client implements ClientDetails {

    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String registeredRedirectUri;
    private Integer AccessTokenValiditySeconds;
    private String authoritie;
    Collection<GrantedAuthority> authorities;

    public Client(String clientId, String resourceIds, String clientSecret, String scope, String authorizedGrantTypes, String registeredRedirectUri, Integer accessTokenValiditySeconds, String authoritie, Collection<GrantedAuthority> authorities) {
        this.clientId = clientId;
        this.resourceIds = resourceIds;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.registeredRedirectUri = registeredRedirectUri;
        AccessTokenValiditySeconds = accessTokenValiditySeconds;
        this.authoritie = authoritie;
        this.authorities = authorities;
    }

    public Client() {
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public void setRegisteredRedirectUri(String registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        AccessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        Set<String> resourceSet=new HashSet<>();
        if (StringUtils.isEmpty(this.resourceIds)){
            return resourceSet;
        }
        Arrays.stream(resourceIds.split(",")).forEach(item->resourceSet.add(item));
        return resourceSet;
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
         Set<String> scopeSet=new HashSet<>();
        if (StringUtils.isEmpty(this.scope)){
            return scopeSet;
        }
        Arrays.stream(scope.split(",")).forEach(item->scopeSet.add(item));
        return scopeSet;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
          Set<String> authorizeGrantTypeSet=new HashSet<>();
        if (StringUtils.isEmpty(this.authorizedGrantTypes)){
            return authorizeGrantTypeSet;
        }
        Arrays.stream(authorizedGrantTypes.split(",")).forEach(item->authorizeGrantTypeSet.add(item));
        return authorizeGrantTypeSet;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        Set<String> registeredRedirectUriSet=new HashSet<>();
        if (StringUtils.isEmpty(this.registeredRedirectUri)){
            return registeredRedirectUriSet;
        }
        Arrays.stream(registeredRedirectUri.split(",")).forEach(item->registeredRedirectUriSet.add(item));
        return registeredRedirectUriSet;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (StringUtils.isEmpty(this.authoritie)){
            return Collections.emptyList();
        }
        Set<SimpleGrantedAuthority> authorities = Arrays.stream(this.authoritie.split(",")).map(item -> new SimpleGrantedAuthority(item)).collect(Collectors.toSet());
        this.authorities = (Collection) authorities;
        return this.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.AccessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.getRefreshTokenValiditySeconds();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

    public String getAuthoritie() {
        return authoritie;
    }

    public void setAuthoritie(String authoritie) {
        this.authoritie = authoritie;
    }
}
