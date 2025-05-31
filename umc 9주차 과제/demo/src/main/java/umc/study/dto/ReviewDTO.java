package umc.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.mapping.Review;

import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor

    public static class UserReviewDTO {
        private Long reviewId;
        private String missionName;
        private String marketName;
        private Float rate;
        private String description;
        private LocalDateTime createdAt;

        public UserReviewDTO( Long reviewId, String missionName, String marketName, Float rate, String description, LocalDateTime createdAt ) {
            this.reviewId = reviewId;
            this.missionName=missionName;
            this.marketName = marketName;
            this.rate = rate;
            this.description = description;
            this.createdAt = createdAt;
        }

        // JPQL의 객체 생성 방식에서는 builder 패턴 사용 불가능, 어절 수 없이 생성자를 사용해야 함
        // 이 DTO에 한하여 builder 대신 생성자 사용 예정
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserReviewListDTO {
        private List<UserReviewDTO>reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private boolean isFirst;
        private boolean isLast;



    }


}
