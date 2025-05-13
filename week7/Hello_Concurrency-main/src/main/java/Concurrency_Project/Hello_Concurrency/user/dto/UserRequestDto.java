package Concurrency_Project.Hello_Concurrency.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequestDto {
        private String username;
        private String password;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignInValidateDto {
        private String email;
        private String username;
    }

    @Getter
    @NoArgsConstructor
    public static class SignInRequestDto {
        private String email;
        private String password;
        private String username;
    }
}
