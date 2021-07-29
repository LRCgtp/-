package com.example.springbootoauth2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_client")
@Builder
public class ClientDTO {
    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String registeredRedirectUri;
    private Integer AccessTokenValiditySeconds;
    private String authoritie;
}
