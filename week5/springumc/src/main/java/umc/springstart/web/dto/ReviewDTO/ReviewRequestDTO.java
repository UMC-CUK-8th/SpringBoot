package umc.springstart.web.dto.ReviewDTO;

import jakarta.validation.constraints.*;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDTO{
        @NotNull
        private Long storeId;

        @NotNull
        private Long memberId;

        @NotBlank
        @Size(min = 10, max = 500)
        private String body;

        @NotNull
        @Min(value = 0)
        @Max(value = 5)
        private Float score;
    }
}
