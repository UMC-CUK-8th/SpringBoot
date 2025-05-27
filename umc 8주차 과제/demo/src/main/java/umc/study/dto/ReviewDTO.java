package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.mapping.Review;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private String missionName;
    private String marketName;
    private Float rate;
    private String description;
    private String picture;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static ReviewDTO fromEntity(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .missionName(review.getMission().getMissionName())
                .marketName(review.getMarket().getName())
                .rate(review.getRate())
                .description(review.getDescription())
                .picture(review.getPicture())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewResponse {
        private Long id;
        private Long missionId;
        private Long marketId;
        private String marketName;
        private Float rate;
        private String description;

        private LocalDateTime createdAt;

    }

}
