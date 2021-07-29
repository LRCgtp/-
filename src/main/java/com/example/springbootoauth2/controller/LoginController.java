package com.example.springbootoauth2.controller;

import com.example.springbootoauth2.entity.UserLogin;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/getUserInfo")
    @ResponseBody
    //@PreAuthorize("hasAuthority('red')")
    public Authentication getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
