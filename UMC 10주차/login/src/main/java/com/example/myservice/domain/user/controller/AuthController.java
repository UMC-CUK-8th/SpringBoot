package com.example.myservice.domain.user.controller;


import com.example.myservice.domain.user.dto.LoginReq;
import com.example.myservice.domain.user.dto.LoginRes;
import com.example.myservice.domain.user.service.AuthService;
import com.example.myservice.global.exception.ApiException;
import com.example.myservice.global.exception.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<LoginRes> login(@Valid @RequestBody LoginReq loginReq){
        try{
            return new ApiResponse<>(authService.login(loginReq));
        } catch(ApiException exception){
            return new ApiResponse<>(exception.getStatus());
        }
    }

    @DeleteMapping("/logout/{email}")
    public ApiResponse<String> logout(@PathVariable String email){
        try{
            return new ApiResponse<>(authService.logout(email));
        } catch(ApiException exception){
            return new ApiResponse<>(exception.getStatus());
        }
    }

}
