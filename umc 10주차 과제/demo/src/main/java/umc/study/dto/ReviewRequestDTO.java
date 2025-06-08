package umc.study.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import umc.study.validation.annotation.ExistMarket;

public class ReviewRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class AddReviewRequest {
        @NotNull
        private Long missionId;
        @NotNull
        @ExistMarket
        private Long marketId;
        @NotNull
        private String marketName;
        @Min(value=1)
        @Max(value=5)
        private Float rate;
        @NotBlank
        private String description;

        private String picture;
    }

}
