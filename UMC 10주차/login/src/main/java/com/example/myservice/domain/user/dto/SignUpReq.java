package com.example.myservice.domain.user.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SignUpReq {
    private String email;

    private String password;

    private String passwordChk;

    private String nickname;

    //private MultipartFile profileImage;
}
