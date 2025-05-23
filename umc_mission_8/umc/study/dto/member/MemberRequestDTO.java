package umc.study.dto.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
//클라이언트(예: 프론트엔드, 앱)에 회원가입이 완료된 후 돌려주는 정보를 담는 DTO(Data Transfer Object)입니다.
//맴버를 생성할때 어떤 값들이 들어가야하는지에 대한 내용
    //컨트롤, 컨버터, 서비스 임플, 서비스(인터페이스) 이렇게 4개의 클래스에서 사용된다
    @Getter
    public static class JoinDto{
        @NotBlank
        private String name;
        @NotNull
        private String nickname;
        @NotNull
        private String email;
        @NotNull
        private int gender; // enum은 컨버터에서 처리
        @ExistCategories
        private List<Long> preferCategory;
        @NotNull
        private LocalDate birth;
        @Size(min = 2, max = 20)
        private String address;
        @NotNull
        private int phoneNumber;
    }
}