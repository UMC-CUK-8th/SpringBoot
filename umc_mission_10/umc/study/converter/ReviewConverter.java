package umc.study.converter;

import umc.study.domain.mapping.Review;
import umc.study.dto.reviewDTO.ReviewRequestDTO;
import umc.study.dto.reviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinDto request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .description(request.getDescription())
                .reply(request.getReply())
                .build();
    }
}
