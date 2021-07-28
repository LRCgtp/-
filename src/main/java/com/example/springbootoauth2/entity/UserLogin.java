package com.example.springbootoauth2.entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * security校验的用户
 */
public class UserLogin implements UserDetails {
    private String username;
    private String password;
    private boolean enabled;
    private boolean countExpired;
    private Collection<? extends GrantedAuthority> authorities;
    private List<String> permissionList;

    public UserLogin(String username, String password, boolean enabled, boolean countExpired, Collection<? extends GrantedAuthority> authorities,List<String> permissionList) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.countExpired = countExpired;
        this.authorities = authorities;
        this.permissionList=permissionList;
    }

    public UserLogin(List<String> permissionList) {
        this.permissionList = permissionList;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
