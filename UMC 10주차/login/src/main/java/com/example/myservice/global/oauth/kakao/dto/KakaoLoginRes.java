package com.example.myservice.global.oauth.kakao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KakaoLoginRes {
    public boolean loginSuccess;
    public long userId;
    public String email;
}
