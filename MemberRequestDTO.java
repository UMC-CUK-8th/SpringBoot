package umcstudy.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umcstudy.study.domain.enums.Role;

public class MemberRequestDTO {

    @Setter
    @NoArgsConstructor
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        String memID;
        @NotBlank
        String password;
        @NotNull
        Integer birth;
        @NotBlank
        String address;
        @NotBlank
        String email;
        @NotBlank
        String foodprefer;
        @NotBlank
        String phonenumber;
        @NotNull
        Role role;
    }
}