package com.example.myservice.domain.user.controller;

import com.example.myservice.domain.user.dto.SignUpReq;
import com.example.myservice.domain.user.dto.UserRes;
import com.example.myservice.domain.user.service.UserService;
import com.example.myservice.global.exception.ApiException;
import com.example.myservice.global.exception.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse<UserRes> signUp(@Valid @ModelAttribute SignUpReq signUpReq){
        try{
            return new ApiResponse<>(userService.signUp(signUpReq));
        } catch(ApiException exception){
            return new ApiResponse<>(exception.getStatus());
        }
    }


}
