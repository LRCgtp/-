package com.example.springbootoauth2.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用户信息实体类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.List;

/**
 * 用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_user")
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer roleId;
    private List<Role> roleList;

}
