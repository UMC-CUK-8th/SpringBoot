package com.example.myservice.domain.user.service;

import com.example.myservice.domain.user.dto.LoginReq;
import com.example.myservice.domain.user.dto.LoginRes;
import com.example.myservice.domain.user.dto.TokenDto;
import com.example.myservice.domain.user.entity.Token;
import com.example.myservice.domain.user.entity.User;
import com.example.myservice.domain.user.repository.TokenRepository;
import com.example.myservice.domain.user.repository.UserRepository;
import com.example.myservice.global.exception.ApiException;
import com.example.myservice.global.exception.ApiResponseStatus;
import com.example.myservice.global.jwt.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public LoginRes login(LoginReq loginReq) throws ApiException {
        User user = userRepository.findByEmail(loginReq.getEmail()).orElseThrow(() ->
                new ApiException(ApiResponseStatus.USER_NOT_FOUND));

        if(!encoder.matches(loginReq.getPassword(), user.getPassword())) {
            throw new ApiException(ApiResponseStatus.PASSWORD_MISSMATCH);
        }else{
            TokenDto tokenDto = jwtUtil.generateToken(user.getId());
            Optional<Token> token = tokenRepository.findByEmail(loginReq.getEmail());

            if(token.isPresent()){
                tokenRepository.save(token.get().updateToken(tokenDto.getRefreshToken()));
            }
            else{
                Token newToken = new Token(tokenDto.getRefreshToken(), loginReq.getEmail());
                tokenRepository.save(newToken);
            }

            String accessToken = tokenDto.getAccessToken();
            String refreshToken = tokenDto.getRefreshToken();

            return new LoginRes(user.getEmail(), accessToken, refreshToken);
        }
    }

    @Transactional
    public String logout(String email){
        Token refreshToken = tokenRepository.findByEmail(email).orElseThrow(() ->
                new ApiException(ApiResponseStatus.USER_NOT_FOUND));
        tokenRepository.delete(refreshToken);

        return "로그아웃 성공";
    }

}
