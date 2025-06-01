package umc.springstart.converter;

import umc.springstart.domain.Member;
import umc.springstart.domain.Review;
import umc.springstart.domain.Store;
import umc.springstart.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.springstart.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.springstart.web.dto.memberDTO.MemberResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.addResultDTO toaddReviewDTO(Review review){
        return ReviewResponseDTO.addResultDTO.builder()
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static Review toReview(ReviewRequestDTO.AddReviewDTO request, Store store, Member member) {
        Review review = Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();

        review.setStore(store);
        review.setMember(member);

        return review;
    }
}
