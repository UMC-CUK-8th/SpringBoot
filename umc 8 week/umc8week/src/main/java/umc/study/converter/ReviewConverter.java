package umc.study.converter;

import umc.study.ApiMission2.code.ReviewRequestDTO;
import umc.study.ApiMission2.code.ReviewResponseDTO;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.UserMain;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO dto, Store store, UserMain userMain) {
        return Review.builder()
                .store(store)
                .userMain(userMain)
                .title(dto.getTitle())
                .score(dto.getScore())
                .body(dto.getBody())
                .build();
    }

    public static ReviewResponseDTO toDTO(Review review) {
        return ReviewResponseDTO.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .body(review.getBody())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .build();
    }
}
