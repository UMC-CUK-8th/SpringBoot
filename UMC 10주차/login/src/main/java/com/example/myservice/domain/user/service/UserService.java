package com.example.myservice.domain.user.service;

import com.example.myservice.domain.user.dto.SignUpReq;
import com.example.myservice.domain.user.dto.UserRes;
import com.example.myservice.domain.user.entity.User;
import com.example.myservice.domain.user.repository.UserRepository;
import com.example.myservice.global.exception.ApiException;
import com.example.myservice.global.exception.ApiResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.myservice.global.exception.ApiResponseStatus.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;// config에서 빈 주입

    public UserRes signUp(SignUpReq signUpReq) throws ApiException{
        if(signUpReq.getPassword().isEmpty()){
            throw new ApiException(PASSWORD_CANNOT_BE_NULL);
        }
        if(!signUpReq.getPassword().equals(signUpReq.getPasswordChk())){
            throw new ApiException(PASSWORD_MISSMATCH);
        }

        String pwd;
        try{
            pwd = encoder.encode(signUpReq.getPassword());
        } catch(Exception ignored){     //암호화 실패시 에러
            throw new ApiException(PASSWORD_ENCRYPTION_ERROR);
        }

        User user = new User(signUpReq.getEmail(), pwd, signUpReq.getNickname());
        userRepository.save(user);

        return new UserRes(user);
    }

}
