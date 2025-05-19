package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistFoods;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        Integer gender;

        @NotNull
        String email;
        @NotNull
        LocalDate birthDate;

        @Size(min = 5, max = 12)
        String address;

        @ExistFoods
        List<Long> userFoodList;


    }
}
