package com.example.springbootoauth2.service;

import com.example.springbootoauth2.entity.Client;
import com.example.springbootoauth2.entity.ClientDTO;
import com.example.springbootoauth2.mapper.ClientMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 客户端业务处理类
 */
@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client=new Client();
        if (StringUtils.isEmpty(clientId)){
            throw new RuntimeException("客户端id不能为空!");
        }
        client.setClientId(clientId);
        List<ClientDTO> clientList = clientMapper.select(ClientDTO.builder().clientId(clientId).build());
        if (CollectionUtils.isEmpty(clientList)){
            return client;
        }
        BeanUtils.copyProperties(clientList.get(0),client);
        return client;
    }
}
