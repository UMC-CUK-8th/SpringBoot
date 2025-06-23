package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistFoods;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class UserRequestDTO {
    @Setter
    @Getter
    public static class JoinDTO {
        @NotBlank
        private String name;
        @NotNull
        private Integer gender;

        @NotNull
        private  LocalDate birthDate;

        @Size(min = 5, max = 12)
        private  String address;
        @NotEmpty
        @ExistFoods
        private List<Long> userFoodList;
        @NotBlank
        @Email
        private String email;    // 이메일 필드 추가
        @NotBlank
        private String password;    // 비밀번호 필드 추가
        @NotNull
        private Role role;    // 역할 필드 추가
    }

    @Getter
    @Setter
    public static class LoginRequestDTO{
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "올바른 이메일 형식이어야 합니다.")
        private String email;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }
}
