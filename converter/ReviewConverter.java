package umcstudy.converter;

import umcstudy.study.domain.Store;
import umcstudy.study.domain.mapping.Reviews;
import umcstudy.web.dto.ReviewRequestDTO;
import umcstudy.web.dto.ReviewResponseDTO;
import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.RevJoinResultDTO toJoinResultDTO(Reviews reviews) {
        return ReviewResponseDTO.RevJoinResultDTO.builder()
                .reviewId(reviews.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Reviews toReview(ReviewRequestDTO.RevJoinDto request, Store store) {

        return Reviews.builder()
                .text(request.getText())
                .reviewstar(request.getReviewstar())
                .store(store)
                .build();
    }
}
