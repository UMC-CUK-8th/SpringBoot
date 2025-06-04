package com.example.myservice.global.config;

import com.example.myservice.global.jwt.JwtFilter;
import com.example.myservice.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtUtil jwtUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .httpBasic(AbstractHttpConfigurer::disable)     //http 기본 인증 비활성화 -> 기본 인증시 인증 정보가 헤더에 노출됨 / 보안 강화
                .csrf(AbstractHttpConfigurer::disable)          //csrf 보호 비활성화  -> RESTful API에서는 클라이언트가 서버와 상태를 유지하지 않는 경우가 많으며, 이 경우 CSRF 보호는 불필요
                .sessionManagement((sessionManagement) -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )       //jwt인증에서는 세션을 사용하지 않기에 세션 생성x 하도록
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .requestMatchers("/api/auth/**").permitAll()     //해당 경로 요청에서는 인증 없이 접근 허용
                        .requestMatchers("/api/oauth2/**").permitAll()
                        .requestMatchers("/api/quote/**").permitAll()
                        .requestMatchers("/api/horoscope/**").permitAll()
                        .requestMatchers("/api/topic/**").permitAll()
                        .requestMatchers("/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**").permitAll()
                        .anyRequest().authenticated()       //그외 모든 요청 인증 요구
                )
                .addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
                //사용자 정의 필터를 UsernamePasswordAuthenticationFilter 앞에 추가
                //클라이언트가 제출한 토큰의 유효성 검사

        return httpSecurity.build();
    }
}
