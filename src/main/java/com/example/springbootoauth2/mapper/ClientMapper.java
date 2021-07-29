package com.example.springbootoauth2.mapper;

import com.example.springbootoauth2.entity.Client;
import com.example.springbootoauth2.entity.ClientDTO;
import com.example.springbootoauth2.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 用户操作接口
 */
public interface ClientMapper extends Mapper<ClientDTO>, MySqlMapper<ClientDTO> {

}
