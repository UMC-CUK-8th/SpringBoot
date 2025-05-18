package Concurrency_Project.Hello_Concurrency.user.dto;

import Concurrency_Project.Hello_Concurrency.user.entity.SocialLogin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignInValidateDto {
        public boolean isValid;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignInDto {
        private String email;
        private String username;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfoDto {
        private String email;
        private String username;
        private Integer postCount;
        private SocialLogin socialLogin;
    }
}
