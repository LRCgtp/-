package com.example.springbootoauth2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * 权限信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_permission")
public class Permission {
    private Integer id;
    private Integer roleId;
    private String permission;
}