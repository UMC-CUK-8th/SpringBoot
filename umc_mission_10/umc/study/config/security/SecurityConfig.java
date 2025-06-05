package umc.study.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //이 어노테이션은 Spring Security 설정을 활성화시키는 역할 ->  Spring Security의 기본 설정보다 우선 적용
@Configuration
public class SecurityConfig {
//애플리케이션의 보안 정책을 정의하는 곳
//이 URL은 누구나 접근 가능하고, 저 URL은 관리자만 접근 가능해 라고 지정하는 곳


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/signup", "/members/signup","/css/**","/index.html").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/swagger", "/swagger/", "/swagger-ui/", "/v3/api-docs/", "/swagger-resources/", "/webjars/").permitAll() // Swagger 허용
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//비밀번호를 암호화하여 저장하기 위해 BCryptPasswordEncoder를 사용
    }
}

