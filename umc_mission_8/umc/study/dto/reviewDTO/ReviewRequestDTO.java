package umc.study.dto.reviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistStores;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        private String title;
        @NotNull
        private int score;
        @NotBlank
        private String description;
        @NotBlank
        private String reply;
        @ExistStores
        private Long storeId; //  가게 ID 받기 위해 추가
        private Long missionId;//미션 아이디를 받기 위해 추가
    }
}