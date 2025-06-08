package umc.study.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class UserRequestDTO {
    @Getter
    @Setter // tymeleaf에서 사용하기 위해 추가
    public static class JoinDTO {
        @NotBlank
        String name;

        @NotBlank
        @Email // 얜뭐지?
        String email; // 이메일 필드 추가
        @NotBlank
        String password; // 비ㅁ번 필드 추가

        @NotNull
        String nickname;
        @NotNull
        String address;
        @NotNull
        Integer gender;
        @NotNull
        String birth;
        @ExistCategories
        List<Long> preferCategory;

        @NotNull
        Role role; // 역할 필드 추가
    }
}
