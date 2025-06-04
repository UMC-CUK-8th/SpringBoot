package com.example.myservice.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRes {
    private String email;
    private String accessToken;
    private String refreshToken;
}
