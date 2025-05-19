package umc.study.converter;

import umc.study.domain.mapping.Review;
import umc.study.dto.ReviewDTO;
import umc.study.dto.ReviewRequestDTO;


public class ReviewConverter {

    // 리퀘스트 dto를 엔티티로 변환
    public static Review toReview(ReviewRequestDTO.AddReviewRequest request) {
        return Review.builder()
                .rate(request.getRate())
                .description(request.getDescription())
                .build();
    }

    // 엔티티를 응답 dto로 변환
    public static ReviewDTO.ReviewResponse toReviewResponse(Review review) {
        return ReviewDTO.ReviewResponse.builder()
                .id(review.getId())
                .missionId(review.getMission().getId())
                .marketId(review.getMarket().getId())
                .marketName(review.getMarket().getName())
                .rate(review.getRate())
                .description(review.getDescription())
                .createdAt(review.getCreatedAt())
                .build();
    }

}
