package umc.springstart.converter;

import umc.springstart.domain.Member;
import umc.springstart.domain.Review;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.addResultDTO toaddReviewDTO(Review review){
        return ReviewResponseDTO.addResultDTO.builder()
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Review toReview(ReviewRequestDTO.AddReviewDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
