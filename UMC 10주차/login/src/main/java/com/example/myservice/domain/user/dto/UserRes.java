package com.example.myservice.domain.user.dto;

import com.example.myservice.domain.user.entity.User;
import lombok.Data;

@Data
public class UserRes {
    private String email;
    private String nickname;

    public UserRes(User user){
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
