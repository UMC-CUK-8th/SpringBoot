package com.example.myservice.global.oauth.kakao.service;

import com.example.myservice.domain.user.entity.User;
import com.example.myservice.domain.user.repository.TokenRepository;
import com.example.myservice.domain.user.repository.UserRepository;
import com.example.myservice.global.jwt.JwtUtil;
import com.example.myservice.global.oauth.kakao.dto.KakaoUserInfoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KakaoService {
    private static final Logger logger = LoggerFactory.getLogger(KakaoService.class);


    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String client_id;
    @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
    private String client_secret;
    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirect_uri;
    @Value("${spring.security.oauth2.client.provider.kakao.token-uri}")
    private String token_uri;
    @Value("${spring.security.oauth2.client.provider.kakao.user-info-uri}")
    private String user_info_uri;

    //프론트에서 받은 인증코드로 카카오서버에 액세스토큰 요청
//    public KakaoTokenDto getKakaoAccessToken(String code){
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        // Http response body 객체 생성
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "authorization_code");
//        params.add("client_id", client_id); // client_id
//        params.add("redirect_uri", redirect_uri); // redirect_uri
//        params.add("code", code);
//        params.add("client_secret", client_secret); // client_secret
//
//        //헤더, 바디 합치기 위해 httpEntity 객체 생성
//        HttpEntity<MultiValueMap<String, String>> kakaoTokenReq = new HttpEntity<>(params, headers);
//
//        //카카오로부터 accesstoken 받아오는
//        RestTemplate rt = new RestTemplate(); //통신용
//        ResponseEntity<String> accessTokenRes = rt.exchange(
//                token_uri,
//                HttpMethod.POST,
//                kakaoTokenReq,
//                String.class
//        );
//
//        // Json parsing (kakatoTokenDto로 변환)
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        // JSON에 포함된 속성이 Java 클래스에 매핑되지 않는 경우에 OM 실패 방지
//
//        KakaoTokenDto kakaoTokenDto = null;
//        try{
//            kakaoTokenDto = objectMapper.readValue(accessTokenRes.getBody(), KakaoTokenDto.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        return kakaoTokenDto;
//    }

    //code로 accessToken 발급받아옴
    public String getToken(String code) throws JsonProcessingException {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
                .fromUriString("https://kauth.kakao.com")
                .path("/oauth/token")
                .encode()
                .build()
                .toUri();

        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP Body 생성
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", client_id);
        body.add("redirect_uri", redirect_uri);
        body.add("code", code);

        RequestEntity<MultiValueMap<String, String>> requestEntity = RequestEntity
                .post(uri)
                .headers(headers)
                .body(body);

        // HTTP 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(
                requestEntity,
                String.class
        );

        // HTTP 응답 (JSON) -> 액세스 토큰 파싱
        JsonNode jsonNode = new ObjectMapper().readTree(response.getBody());
        return jsonNode.get("access_token").asText();
    }

//    //액세스토큰으로 사용자 정보 불러오기
//    public User getKakaoInfo(String kakaoAccessToken){
//
//        //Httpheader 생성 (userinfo 받아오기 위한)
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer "+ kakaoAccessToken);
//        httpHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        //http헤더와 바디를 httpEntity에 담기 (body 생략 가능)
//        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
//
//        //http 요청 처리하기 위해 restTemplate 사용
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                user_info_uri,      //요청 url
//                HttpMethod.GET,     //http메소드
//                request,            //요청의 헤더와 바디 설정
//                String.class        //요청 응답 형식 설정
//        );
//
//        //카카오 서버에서 반환한 responseentity의 body로 부터 사용자 정보
//        String userInfo = responseEntity.getBody();
//
//        Gson gsonObj = new Gson();  //Gson 으로 반환시 objectmapper와 다르게 클래스와 json데이터 일치 여부에 상관없이 필요한 정보 추출 가능
//        Map<String, Object> data = gsonObj.fromJson(userInfo, Map.class);
//
//        //닉네임은 필수 동의
//        String nickName = (String) ((Map<String, Object>) data.get("properties")).get("nickname");
//
//        // 이메일 동의 여부 확인
//        Map<?, ?> kakaoAccount = (Map<?, ?>) data.get("kakao_account");
//        boolean emailAgreement = (boolean) kakaoAccount.get("email_needs_agreement");
//        String email = emailAgreement ? "" : (String) kakaoAccount.get("email");
//
//        User user = new User().builder()
//                .email(email)
//                .nickname(nickName)
//                .build();
//
//        return user;
//    }

    public KakaoUserInfoDto getKakaoUserInfo(String accessToken) throws JsonProcessingException {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
                .fromUriString("https://kapi.kakao.com")
                .path("/v2/user/me")
                .encode()
                .build()
                .toUri();

        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);  //bearer: 토큰임을 알려주는 식별자
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        RequestEntity<MultiValueMap<String, String>> requestEntity = RequestEntity
                .post(uri)
                .headers(headers)
                .body(new LinkedMultiValueMap<>());

        // HTTP 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(
                requestEntity,
                String.class
        );

        JsonNode jsonNode = new ObjectMapper().readTree(response.getBody());
        Long id = jsonNode.get("id").asLong();
        String nickname = jsonNode.get("properties")
                .get("nickname").asText();
        String email = jsonNode.get("kakao_account")
                .get("email").asText();

        logger.info("카카오 사용자 정보: " + id + ", " + nickname + ", " + email);
        return new KakaoUserInfoDto(id, nickname, email);
    }

//    //카카오 로그인
//    public KakaoLoginRes kakaoLogin(String kakaoAccessToken){
//        User user = getKakaoInfo(kakaoAccessToken);
//
//        //조회해온 유저 이메일로 회원가입 되어있는지 확인
//        User existUser = userRepository.findByEmail(user.getEmail()).orElse(null);
//        if(existUser == null){  //회원가입 x 상태면 유저 save 후 토큰 발급
//            userRepository.save(user);
//        }
//
//        //회원가입 되어있으면
//        TokenDto tokenDto = jwtUtil.generateToken(user.getId());    //토큰 발급
//
//        Token token = tokenRepository.findByEmail(user.getEmail()).orElse(null);    //카카오 유저 정보로 토큰 조회
//
//        if(token != null){  //토큰이 있다면 기존 토큰을 새로 생성한 토큰으로 업데이트
//            tokenRepository.save(token.updateToken(tokenDto.getRefreshToken()));
//        }else{
//            Token newToken = new Token(tokenDto.getRefreshToken(), user.getEmail());
//            tokenRepository.save(newToken);
//        }
//
//        return new KakaoLoginRes(true, existUser==null ? user.getId() : existUser.getId(), user.getEmail());
//    }

    public String kakaoLogin(String code) throws JsonProcessingException{
        //인가 코드로 카카오 액세스토큰 요청
        String accessToken = getToken(code);

        // 토큰으로 카카오 api 호출 -> 카카오 사용자 정보 가져오기
        KakaoUserInfoDto kakaoUserInfo = getKakaoUserInfo(accessToken);

        // 3. 필요시에 회원가입
        User kakaoUser = registerKakaoUserIfNeeded(kakaoUserInfo);

        // 4. JWT 토큰 생성 후 반환
        String createToken =  jwtUtil.createToken(kakaoUser.getId());

        return createToken;
    }

//    public String kakaoLogout(String kakaoAccessToken) throws JsonProcessingException {
//        // HTTP Header 생성
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + kakaoAccessToken);
//
//        // HTTP 요청 보내기
//        HttpEntity<MultiValueMap<String, String>> kakaoLogoutRequest = new HttpEntity<>(headers);
//        RestTemplate rt = new RestTemplate();
//        ResponseEntity<String> response = rt.exchange(
//                "https://kapi.kakao.com/v1/user/logout",
//                HttpMethod.POST,
//                kakaoLogoutRequest,
//                String.class
//        );
//
////        // responseBody에 있는 정보를 꺼냄
////        String responseBody = response.getBody();
////        ObjectMapper objectMapper = new ObjectMapper();
////        JsonNode jsonNode = objectMapper.readTree(responseBody);
//
//        String userEmail = getKakaoInfo(kakaoAccessToken).getEmail();
//        Token token = tokenRepository.findByEmail(userEmail).orElseThrow(() ->
//                new ApiException(ApiResponseStatus.USER_NOT_FOUND));    //해당 유저 토큰이 존재x면 예외처리
//
//        tokenRepository.delete(token);  //존재하면 토큰 삭제
//
////        Long id = jsonNode.get("id").asLong();
//
//        return "로그아웃 성공";
//    }

    private User registerKakaoUserIfNeeded(KakaoUserInfoDto kakaoUserInfo) {
        // DB 에 중복된 Kakao Id 가 있는지 확인
        Long kakaoId = kakaoUserInfo.getId();
        User kakaoUser = userRepository.findByKakaoId(kakaoId).orElse(null);

        if (kakaoUser == null) {
            // 카카오 사용자 email 동일한 email 가진 회원이 있는지 확인
            String kakaoEmail = kakaoUserInfo.getEmail();
            User sameEmailUser = userRepository.findByEmail(kakaoEmail).orElse(null);
            if (sameEmailUser != null) {    //로그인 한 이력 있으면
                kakaoUser = sameEmailUser;
                // 기존 회원정보에 카카오 Id 추가 (user에 덮어 씌움)
                kakaoUser = kakaoUser.kakaoIdUpdate(kakaoId);
            } else {    //아예 처음이면
                // 신규 회원가입
                // password: random UUID
                String password = UUID.randomUUID().toString();
                String encodedPassword = passwordEncoder.encode(password);

                // email: kakao email
                String email = kakaoUserInfo.getEmail();

                kakaoUser = new User(email, encodedPassword, kakaoUserInfo.getNickname(), kakaoId);
            }

            userRepository.save(kakaoUser);
        }
        return kakaoUser;
    }

}
