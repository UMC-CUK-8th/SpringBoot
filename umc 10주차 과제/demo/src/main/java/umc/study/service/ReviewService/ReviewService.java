package umc.study.service.ReviewService;

import umc.study.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    Long addReview(Long missionId, Long marketId, Float rate, String description, String picture);
    // 리뷰 추가하기


    ReviewDTO.UserReviewListDTO getUserReviews(Long userId, Integer page);
}
