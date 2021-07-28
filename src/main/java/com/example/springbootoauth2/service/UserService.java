package com.example.springbootoauth2.service;

import com.example.springbootoauth2.entity.User;
import com.example.springbootoauth2.entity.UserLogin;
import com.example.springbootoauth2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名获取登陆用户信息
     * @param userName
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        if (StringUtils.isEmpty(userName)){
            throw new RuntimeException("用户名不能为空!");
        }
        List<User> userList = userMapper.getUserByUserName(userName);
        if (CollectionUtils.isEmpty(userList)){
            throw new RuntimeException("用户不存在!");
        }
        return createUserDetails(userList.get(0));
    }

    private UserDetails createUserDetails(User user) {
        //获取角色
        Set<SimpleGrantedAuthority> authorities = user.getRoleList().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
        //获取权限
        Set<String> permissionList = user.getRoleList().stream().flatMap(item -> item.getPermissionList().stream()).map(permission ->
                permission.getPermission()).collect(Collectors.toSet());
        UserLogin userLogin=new UserLogin(user.getUserName(),user.getPassword(),true,true,authorities,new ArrayList<>(permissionList));
        return userLogin;
    }
}
