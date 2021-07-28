package com.example.springbootoauth2.mapper;

import com.example.springbootoauth2.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 用户操作接口
 */
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    List<User> getUserByUserName(@Param("userName") String userName);

}
