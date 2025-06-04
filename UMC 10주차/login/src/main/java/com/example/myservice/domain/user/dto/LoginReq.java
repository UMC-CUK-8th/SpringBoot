package com.example.myservice.domain.user.dto;

import lombok.Data;

@Data
public class LoginReq {
    private String email;
    private String password;
}
