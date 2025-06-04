package com.example.myservice.global.jwt;

import com.example.myservice.domain.user.dto.TokenDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@Slf4j  //로깅 코드 자동으로 생성
@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final UserDetailsServiceImpl userDetailsService;
    @Value("${app.jwt.secretKey}")
    private String secretKey;

    private Key key;
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = Duration.ofMinutes(60).toMillis();     //만료 시간 60분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = Duration.ofDays(14).toMillis();   //만료시간 2주
    //toMillis: long 타입 반환

    //비밀키 생성   //yml에 생성해둔 secretKey를 디코딩
//    private Key key = Keys.hmacShaKeyFor
//            (Decoders.BASE64URL.decode(secretKey));
    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        key = Keys.hmacShaKeyFor(bytes);
    }

    //access, refresh token 생성
    public TokenDto generateToken(Long userId){
        return new TokenDto(createToken(userId), createRefreshToken(userId));
    }

    //액세스 토큰
    public String createToken(Long userId){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + ACCESS_TOKEN_EXPIRE_TIME);

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)   //jwt헤더 구성  ("typ", "JWT")
                .claim("userId", userId)    //claim 정보 설정
                .setIssuer("test")  //토큰발급주체 (필수는 아니나 보안상 권장사항)
                .setIssuedAt(now)   //발급시간(iat)
                .setExpiration(expiration)  //만료시간
                .signWith(key, SignatureAlgorithm.HS256)  //설정 키와 서명 알고리즘(HS256)으로 서명
                .compact();  //jwt를 문자열로 변환
    }

    //리프레쉬 토큰
    public String createRefreshToken(Long userId) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + REFRESH_TOKEN_EXPIRE_TIME); // 만료기간 14일

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .claim("userId", userId)
                .setIssuer("test")
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    //토큰 정보 검증
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);     //parserbuilder 메소드에서 parser메소드로 바뀜
            return true;
        } catch(SecurityException | MalformedJwtException e){
            log.info("Invalid JWT Token", e);   //잘못된 jwt 서명
        } catch(ExpiredJwtException e){
            log.info("Expired JWT Token", e);   //만료
        } catch(UnsupportedJwtException e){
            log.info("Unsupported JWT Token", e);   //지원 x
        } catch(IllegalArgumentException e){
            log.info("JWT claims string is empty", e);  //jwt 토큰이 잘못됨
        } catch(Exception e){
            log.error(e.getMessage());
        }
        return false;
    }

    //주어진 Access Token을 복호화(디코딩), 해당 토큰의 클레임 정보 추출
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parser().setSigningKey(key).build()  //jwt파서 생성, 파싱시 사용할 서명키(key) 설정
                    .parseClaimsJws(accessToken).getBody();   //AccessToken을 파싱하여 변환한 jws객체에서 클레임 추출
            //jws: jwt의 서명을 나타내는 부분
        } catch (ExpiredJwtException e) {   //토큰 만료시
            return e.getClaims();   //예외 객체에서 만료된 토큰의 클레임 정보 추출
        }
    }

    //customuserdetailsservice 생성 후 추가 수정 예정
    public Authentication getAuthentication(String token){
        String email = parseClaims(token).get("email").toString();
        UserDetailsImpl userDetailsImpl = userDetailsService.loadUserByUsername(email);   // 사용자 ID를 사용하여 사용자 정보를 로드하고, 해당 사용자에 대한 Authentication 객체를 가져옴
        return new UsernamePasswordAuthenticationToken(userDetailsImpl, "", userDetailsImpl.getAuthorities());      // 가져온 Authentication 객체를 반환
    }


//    public Authentication getAuthentication(String accessToken) {
//        Claims claims = parseClaims(accessToken);
//        String memberId = claims.get("userId").toString();
//        Long userId = Long.valueOf(memberId);
//
//        // 사용자 ID를 사용하여 사용자 정보를 로드하고, 해당 사용자에 대한 Authentication 객체를 가져옴
//        UserDetails userDetails = customUserDetailsService.loadUserById(userId);
//
//        // 가져온 Authentication 객체를 반환
//        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//    }

}
