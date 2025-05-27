package umc.study.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.enums.Gender;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class UserRequestDTO {
    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        String nickname;
        @NotNull
        Integer gender;
        @NotNull
        String birth;
        @ExistCategories
        List<Long> preferCategory;
    }
}
