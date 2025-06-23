package umc.spring.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import umc.spring.config.security.jwt.JwtAuthenticationFilter;
import umc.spring.config.security.jwt.JwtTokenProvider;


@EnableWebSecurity//Spring Security 활성화
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;

    @Bean//SecurityFilterChain을 정의- HttpSecurity 객체로 다양한 보안 설정을 구성
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(
                        (requests) -> requests
                                .requestMatchers("/", "/users/", "/users/login", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .csrf()
                .disable()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);




                /*//http요청에 대한 접근제어 설정
                .authorizeHttpRequests((requests) -> requests
                        // 특정 URL 패턴에 대한 접근 권한을 설정
                        .requestMatchers("/", "/home", "/signup","/users/signup", "/css/**")
                        //인증 없이 접근 가능한 경로를 지정
                        .permitAll()
                        .requestMatchers("/admin/**")
                        //'ADMIN' 역할을 가진 사용자만 접근 가능하도록 제한
                        .hasRole("ADMIN")
                        //그 외 모든 요청에 대해 인증을 요구
                        .anyRequest().authenticated()
                )
                //폼 기반 로그인에 대한 설정
                .formLogin((form) -> form
                        //커스텀 로그인 페이지를 /login 경로로 지정
                        .loginPage("/login")
                        //로그인 성공 시 /home으로 리다이렉트
                        .defaultSuccessUrl("/home", true)
                        //로그인 페이지는 모든 사용자가 접근 가능하도록 설정
                        .permitAll()
                )
                //로그아웃 처리에 대한 설정
                .logout((logout) -> logout
                        // /logout 경로로 로그아웃을 처리
                        .logoutUrl("/logout")
                        //로그아웃 성공 시 /login?logout으로 리다이렉트
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );*/

        return http.build();



        /*http
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(//http요청에 대한 접근제어 설정
                        (requests) -> requests
                                // 특정 URL 패턴에 대한 접근 권한을 설정
                                .requestMatchers("/", "/members/join", "/members/login", "/swagger-ui/**", "/v3/api-docs/**")
                                //인증 없이 접근 가능한 경로를 지정
                                .permitAll()
                                .requestMatchers("/admin/**")
                                //'ADMIN' 역할을 가진 사용자만 접근 가능하도록 제한
                                .hasRole("ADMIN")
                                //그 외 모든 요청에 대해 인증을 요구
                                .anyRequest().authenticated()
                )
                .csrf()
                .disable()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();*/
    }
    //비밀번호를 암호화하여 저장하기 위해 BCryptPasswordEncoder를 사용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
