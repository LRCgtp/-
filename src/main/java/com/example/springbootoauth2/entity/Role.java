package com.example.springbootoauth2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.List;

/**
 * 角色信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_role")
public class Role {
    private Integer id;
    private String roleName;
    private String remark;
    private List<Permission> permissionList;
}


