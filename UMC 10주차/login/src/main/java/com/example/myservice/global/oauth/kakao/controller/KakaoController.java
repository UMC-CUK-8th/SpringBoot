package com.example.myservice.global.oauth.kakao.controller;

import com.example.myservice.global.oauth.kakao.service.KakaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth2")
public class KakaoController {

    private final KakaoService kakaoService;
    private final Logger logger = LoggerFactory.getLogger(KakaoController.class);

    @GetMapping("/code/kakao")
    public ResponseEntity<?> callback(@RequestParam("code") String code) throws JsonProcessingException {
//        String accessToken = kakaoService.getToken(code);
//        KakaoUserInfoDto userInfo = kakaoService.getKakaoUserInfo(accessToken);

        //사용자의 카카오 로그인 바탕으로 서버 측 사용자 로그인 혹은 회원가입 처리
        String jwtToken = kakaoService.kakaoLogin(code);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/code/kakao")
//    public KakaoLoginRes kakaoLogin(@RequestParam("code") String code) {
//        String kakaoAccessToken = kakaoService.getKakaoAccessToken(code).getAccess_token();
//        return new ApiResponse<>(kakaoService.kakaoLogin(kakaoAccessToken)).getResult();
//    }

//    @GetMapping("/code/kakao")
//    public ResponseEntity<?> kakaoLogin(@RequestParam("code") String code) {
//        logger.info("Received code: {}", code);
//
//        try {
//            String kakaoAccessToken = kakaoService.getKakaoAccessToken(code).getAccess_token();
//            logger.info("Received access token: {}", kakaoAccessToken);
//            KakaoLoginRes response = kakaoService.kakaoLogin(kakaoAccessToken);
//            logger.info("Login response: {}", response);
//            return ResponseEntity.ok(new ApiResponse<>(response).getResult());
//        } catch (Exception e) {
//            logger.error("Error during Kakao login", e);
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("/code/kakao")
//    public String kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
//        String token = kakaoService.kakaoLogin(code);
//
//        //쿠키 생성 후 헤더와 토큰 넣어서 response에 쿠키 넣음
//        Cookie cookie = new Cookie("Authorization", token);
//        cookie.setPath("/");
//        response.addCookie(cookie);     //브라우저 쿠키 저장소에 토큰을 set
//
//        return "redirect:/";
//    }


}
