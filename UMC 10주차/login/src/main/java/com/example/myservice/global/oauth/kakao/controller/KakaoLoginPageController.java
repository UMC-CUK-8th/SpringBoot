package com.example.myservice.global.oauth.kakao.controller;

import com.example.myservice.global.oauth.kakao.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/oauth2")
public class KakaoLoginPageController {

    private final KakaoService kakaoService;

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String client_id;
    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirect_uri;

    @GetMapping("/page")
    public String loginPage(Model model) {
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+client_id+"&redirect_uri="+redirect_uri;
        model.addAttribute("location", location);

        return "login";
    }

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

//    @GetMapping("/code/kakao")
//    public String kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
//        String token = kakaoService.kakaoLogin(code);
//
//        Cookie cookie = new Cookie("Authorization", token);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//
//        return "redirect:/";
//    }
}
